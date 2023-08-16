package com.example.vaccinationbookingsystem.Service;

import com.example.vaccinationbookingsystem.Dto.RequestDto.BookDose1RequestDto;
import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Exception.DoseAlreadyTakenException;
import com.example.vaccinationbookingsystem.Exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Repository.DoseRepository;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;
@Service
public class DoseService {
    @Autowired
    PersonRepository personRepository;

//    public Dose getDose1(int personId, DoseType doseType) {
//        Optional<Person> optionalPerson= personRepository.findById(personId);
//
//        //check if person exists or not
//        if (!optionalPerson.isPresent()) {
//            throw new PersonNotFoundException("Invalid PersonId");
//        }
//
//        Person person = optionalPerson.get();
//
//        //check if dose1 is already taken
//        if (person.isDose1Taken()){
//            throw new DoseAlreadyTakenException("Dose 1 already taken");
//        }
//        //create a dose
//        Dose dose = new Dose();
//        dose.setDoseId(Integer.parseInt(String.valueOf(UUID.randomUUID())));
//        dose.setDoseType(doseType);
//        dose.setPerson(person);
//
//        person.setDose1Taken(true);
//        person.getDosesTaken().add(dose);
//        Person savedPerson = personRepository.save(person);
//
//        return savedPerson.getDosesTaken().get(0);
//        }

    public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {
        Optional<Person> optionalPerson= personRepository.findById(bookDose1RequestDto.getPersonId());

        //check if person exists or not
        if (!optionalPerson.isPresent()) {
            throw new PersonNotFoundException("Invalid PersonId");
        }

        Person person = optionalPerson.get();

        //check if dose1 is already taken
        if (person.isDose1Taken()){
            throw new DoseAlreadyTakenException("Dose 1 already taken");
        }
        //create a dose from requestDto
        Dose dose = new Dose();
        dose.setDoseId(Integer.parseInt(String.valueOf(UUID.randomUUID())));
        dose.setDoseType(bookDose1RequestDto.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);
        person.getDosesTaken().add(dose);
        Person savedPerson = personRepository.save(person);

        return savedPerson.getDosesTaken().get(0);
    }
    }


