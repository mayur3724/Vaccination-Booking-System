package com.example.vaccinationbookingsystem.Service;
import com.example.vaccinationbookingsystem.Dto.RequestDto.DoctorRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.CentreResponseDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.DoctorResponseDto;
import com.example.vaccinationbookingsystem.Exception.CentreNotFoundException;
import com.example.vaccinationbookingsystem.Exception.DoctorNotFoundException;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Model.VaccinationCentre;
import com.example.vaccinationbookingsystem.Repository.DoctorRepository;
import com.example.vaccinationbookingsystem.Repository.VaccinationCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {
    @Autowired
    VaccinationCentreRepository centreRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Optional<VaccinationCentre> vaccinationCentreOptional = centreRepository.findById(doctorRequestDto.getCentreId());
        if (vaccinationCentreOptional.isEmpty()) {
            throw new CentreNotFoundException("Wrong Centre Id");
        }

        VaccinationCentre centre = vaccinationCentreOptional.get();

        //create doctor entity
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setCentre(centre);

        //add in centre doctorlist
        centre.getDoctor().add(doctor);

        VaccinationCentre savedCentre = centreRepository.save(centre);//will save both doctor and centre

        //prepare response dto
        List<Doctor> doctors = savedCentre.getDoctor();
        Doctor latestSavedDoctor = doctors.get(doctors.size() - 1);

        CentreResponseDto centreResponseDto = new CentreResponseDto();
        centreResponseDto.setCentreType(savedCentre.getCentreType());
        centreResponseDto.setCentreName(savedCentre.getCentreName());
        centreResponseDto.setAddress(savedCentre.getAddress());

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(latestSavedDoctor.getName());
        doctorResponseDto.setMessage("You Have Been Registered Successfully");
        doctorResponseDto.setCentreResponseDto(centreResponseDto);
        return doctorResponseDto;
    }
    public List<String> getAgeGreaterThan(DoctorRequestDto doctorRequestDto) {
        List<Doctor> doctorsList = doctorRepository.getByAgeGreaterThan(doctorRequestDto.getAge());
        List<String> ans = new ArrayList<>();
        for (Doctor d : doctorsList)
            ans.add(d.getName());
        return ans;
    }
    public List<String> getByAgeGreaterThan(int age) {
        List<Doctor> doctors = doctorRepository.getByAgeGreaterThan(age);
        List<String> ans = new ArrayList<>();
        for (Doctor d : doctors) {
            ans.add(d.getName());
        } return ans;
    }
//    @GetMapping("/doctor_with_highest_appointment")
//    public List<DoctorResponseDto> doctorWithHighestAppointment() {
//        List<Doctor> doctorList = doctorRepository.findAll();
//        //now loop around and find for max appointment
//        int maxAppointment = 0;
//        for (Doctor currDoctor : doctorList) {
//            maxAppointment = Math.max(maxAppointment, currDoctor.getAppointments().size());
//        }
//        //check for appointment
//        if(maxAppointment==0){
//            throw new DoctorNotFoundException("No appointment Booked Yet");
//        }
//        //now loop around and store doctor name having max appointment
//        List<DoctorResponseDto> doctorListWithHighestAppointment = new ArrayList<>();
//        for(Doctor currDoctor : doctorList){
//            if(currDoctor.getAppointments().size()==maxAppointment){
//                doctorListWithHighestAppointment.add();
//            }
//        }
    }


