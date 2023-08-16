package com.example.vaccinationbookingsystem.Dto.ResponseDto;
import com.example.vaccinationbookingsystem.Dto.RequestDto.CentreRequestDto;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookAppointmentResponseDto {
    String personName;
    String doctorName;
    CentreResponseDto centreResponseDto;
    Date appointmentDate;
    int appointmentId;

}
