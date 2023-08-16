package com.example.vaccinationbookingsystem.Service;
import com.example.vaccinationbookingsystem.Dto.RequestDto.CentreRequestDto;
import com.example.vaccinationbookingsystem.Dto.ResponseDto.CentreResponseDto;
import com.example.vaccinationbookingsystem.Model.VaccinationCentre;
import com.example.vaccinationbookingsystem.Repository.VaccinationCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class VaccinationCentreService {
@Autowired
VaccinationCentreRepository centreRepository;
public CentreResponseDto addCentre(CentreRequestDto centreRequestDto) {
    //convert request dto to entity
    VaccinationCentre centre = new VaccinationCentre();
    centre.setCentreName(centreRequestDto.getCentreName());
    centre.setCentreType(centreRequestDto.getCentreType());
    centre.setAddress(centreRequestDto.getAddress());

    //save entity to db
    VaccinationCentre savedCentre = centreRepository.save(centre);

    //entity to response dto
    CentreResponseDto centreResponseDto = new CentreResponseDto();
    centreResponseDto.setCentreName(savedCentre.getCentreName());
    centreResponseDto.setCentreType(savedCentre.getCentreType());
    centreResponseDto.setAddress(savedCentre.getAddress());
    return centreResponseDto;
}
}
