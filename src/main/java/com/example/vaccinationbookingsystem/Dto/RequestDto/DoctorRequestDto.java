package com.example.vaccinationbookingsystem.Dto.RequestDto;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DoctorRequestDto {
    String name;
    int age;
    String emailId;
    Gender gender;
    int centreId;
}
