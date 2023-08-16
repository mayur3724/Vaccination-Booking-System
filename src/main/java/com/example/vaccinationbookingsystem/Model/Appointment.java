package com.example.vaccinationbookingsystem.Model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int appointmentId;
    Date appointmentDate;
    @ManyToOne
    @JoinColumn
    Person person;
    @ManyToOne
    @JoinColumn
    Doctor doctor;

}
