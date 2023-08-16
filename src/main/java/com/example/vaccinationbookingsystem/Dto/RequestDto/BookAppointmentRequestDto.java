package com.example.vaccinationbookingsystem.Dto.RequestDto;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookAppointmentRequestDto {
    int personId;
    int doctorId;

}
