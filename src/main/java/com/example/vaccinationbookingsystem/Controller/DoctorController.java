package com.example.vaccinationbookingsystem.Controller;
import com.example.vaccinationbookingsystem.Dto.RequestDto.DoctorRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.DoctorResponseDto;
import com.example.vaccinationbookingsystem.Model.Doctor;
import com.example.vaccinationbookingsystem.Repository.DoseRepository;
import com.example.vaccinationbookingsystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<String> getByAgeGreaterThan(@RequestParam("age") int age) {
        List<String> doctors = doctorService.getByAgeGreaterThan(age);
        return doctors;
    }
//    @GetMapping("/doctor_with_highest_appointment")
//    public ResponseEntity doctorWithHighestAppointment() {
//        try {
//            List<DoctorResponseDto> doctorList = doctorService.doctorWithHighestAppointment();
//            return new ResponseEntity(doctorList, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
    }

