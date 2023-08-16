package com.example.vaccinationbookingsystem.Model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Certificate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
   int certificateNo;
   String confirmationMessage;
   @JoinColumn
   @OneToOne
   Person person;

}
