package com.example.vaccinationbookingsystem.Dto.RequestDto;
import com.example.vaccinationbookingsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPersonRequestDto {
    String name;
    int age;
    String emailID;
    Gender gender;

}
