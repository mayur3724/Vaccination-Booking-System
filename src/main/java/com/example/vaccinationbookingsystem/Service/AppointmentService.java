package com.example.vaccinationbookingsystem.Service;
import com.example.vaccinationbookingsystem.Dto.RequestDto.BookAppointmentRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.BookAppointmentResponseDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.CentreResponseDto;
import com.example.vaccinationbookingsystem.Exception.DoctorNotFoundException;
import com.example.vaccinationbookingsystem.Exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.Model.Appointment;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Model.VaccinationCentre;
import com.example.vaccinationbookingsystem.Repository.AppointmentRepository;
import com.example.vaccinationbookingsystem.Repository.DoctorRepository;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;
import static java.awt.SystemColor.text;
@Service
public class AppointmentService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto) {
        Optional<Person> optionalPerson = personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if(optionalPerson.isEmpty()){
            throw  new PersonNotFoundException("Invalid PersonId");
        }
        Optional<Doctor> optionalDoctor = doctorRepository.findById(bookAppointmentRequestDto.getDoctorId());
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid DoctorId");
        }
        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        //create an appointment object
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(Integer.parseInt(String.valueOf(UUID.randomUUID())));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        doctor.getAppointments().add(appointment);
        person.getAppointments().add(appointment);

        Doctor savedDoctor = doctorRepository.save(doctor);
        Person savedPerson = personRepository.save(person);
        VaccinationCentre centre = savedDoctor.getCentre();

        //send an email

        String text = "Congrats!"+savedPerson.getName()+"Your Appointment has been booked with Doctor" +
                savedDoctor.getName() + "Your Vaccination centre name is :" +
                centre.getCentreName() +"Please reach at these address"+
                centre.getAddress() + "at this time:"+ savedAppointment.getAppointmentDate() +"Dhanyawad!!!";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mayurpagare235@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats! Appointment Done!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

        //prepare the response dto

        CentreResponseDto centreResponseDto = new CentreResponseDto();
        centreResponseDto.setCentreName(centre.getCentreName());
        centreResponseDto.setCentreType(centre.getCentreType());
        centreResponseDto.setAddress(centre.getAddress());

        BookAppointmentResponseDto bookAppointmentResponseDto = new BookAppointmentResponseDto();
        bookAppointmentResponseDto.setPersonName(savedPerson.getName());
        bookAppointmentResponseDto.setDoctorName(savedDoctor.getName());
        bookAppointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());
        bookAppointmentResponseDto.setCentreResponseDto(centreResponseDto);

        return bookAppointmentResponseDto;
    }
}
