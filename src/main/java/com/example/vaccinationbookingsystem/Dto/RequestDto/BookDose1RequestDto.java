package com.example.vaccinationbookingsystem.Dto.RequestDto;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDose1RequestDto {
    int personId;
    DoseType doseType;

}
