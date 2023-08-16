package com.example.vaccinationbookingsystem.Service;
import com.example.vaccinationbookingsystem.Dto.RequestDto.AddPersonRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.AddPersonResponseDto;
import com.example.vaccinationbookingsystem.Exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {
        //convert requestDto to entity
        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmailID());
        person.setGender(addPersonRequestDto.getGender());

        person.setDose1Taken(false);//by default will be false
        person.setDose2Taken(false);//by default will be false
        person.setCertificate(null);//by default will be null only
        Person savedPerson=personRepository.save(person);

        //saved entity to response dto
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("Congrats,you have been registered successfully");
        return addPersonResponseDto;
    }
    public String updateEmail(String oldEmail, String newEmail) {
        Person person = personRepository.findByEmailId(oldEmail);
        if(person==null){
            throw new PersonNotFoundException("Email DoesNot Exist");
        }
        person.setEmailId(newEmail);
        personRepository.save(person);
        return "Email updated successfully";
    }
}
