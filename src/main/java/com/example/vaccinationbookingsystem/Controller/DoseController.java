package com.example.vaccinationbookingsystem.Controller;
import com.example.vaccinationbookingsystem.Dto.RequestDto.BookDose1RequestDto;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
//    @PostMapping("/getDose1")
//    public ResponseEntity getDose1(@RequestParam("id") int personId, @RequestParam("doseType") DoseType doseType) {
//        try {
//            Dose doseTaken = doseService.getDose1(personId, doseType);
//            return new ResponseEntity(doseTaken, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/getDose1")
    public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto) {
        try {
            Dose doseTaken = doseService.getDose1(bookDose1RequestDto);
            return new ResponseEntity(doseTaken, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
