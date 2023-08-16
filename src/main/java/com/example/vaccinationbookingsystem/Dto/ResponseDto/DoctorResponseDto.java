package com.example.vaccinationbookingsystem.Dto.ResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DoctorResponseDto {
    String name;
     String message;
     CentreResponseDto centreResponseDto;

}
