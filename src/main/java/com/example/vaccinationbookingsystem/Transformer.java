package com.example.vaccinationbookingsystem;

import com.example.vaccinationbookingsystem.Dto.RequestDto.DoctorRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.DoctorResponseDto;
import com.example.vaccinationbookingsystem.Model.Doctor;

public class Transformer {
    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

//    public static DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor){
//        return DoctorResponseDto.builder()
//                .name(doctor.getName())
//                .centreResponseDto(doctor.)
//                .build();
//    }
}
