package com.example.vaccinationbookingsystem.Dto.RequestDto;

import com.example.vaccinationbookingsystem.Enum.CentreType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CentreRequestDto {
    String centreName;
    String address;
    CentreType centreType;

}
