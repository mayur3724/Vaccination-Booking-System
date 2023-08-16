package com.example.vaccinationbookingsystem.Dto.ResponseDto;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPersonResponseDto {
    String name;
    String message;

}
