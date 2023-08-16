package com.example.vaccinationbookingsystem.Controller;
import com.example.vaccinationbookingsystem.Dto.RequestDto.AddPersonRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.AddPersonResponseDto;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto) {
        try {
            AddPersonResponseDto personResponse = personService.addPerson(addPersonRequestDto);
            return new ResponseEntity(personResponse, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail,
                                      @RequestParam ("newEmail") String newEmail){
        try{
            String response= personService.updateEmail(oldEmail,newEmail);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
