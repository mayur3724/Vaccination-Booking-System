package com.example.vaccinationbookingsystem.Controller;

import com.example.vaccinationbookingsystem.Dto.RequestDto.CentreRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.CentreResponseDto;
import com.example.vaccinationbookingsystem.Enum.CentreType;
import com.example.vaccinationbookingsystem.Service.VaccinationCentreService;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/centre")
public class VaccinationCentreController {
    @Autowired
    VaccinationCentreService centreService;
    @PostMapping("/add")
    public CentreResponseDto addCentre(@RequestBody CentreRequestDto centreRequestDto){
        CentreResponseDto centreResponseDto = centreService.addCentre(centreRequestDto);
        return centreResponseDto;
    }
}
