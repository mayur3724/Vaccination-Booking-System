package com.example.vaccinationbookingsystem.Dto.ResponseDto;

import com.example.vaccinationbookingsystem.Enum.CentreType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CentreResponseDto {
    String centreName;
    String address;
    CentreType centreType;

}
