package com.example.vaccinationbookingsystem.Model;
import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true,nullable = false)
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appointment> appointments=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    VaccinationCentre centre;

}
