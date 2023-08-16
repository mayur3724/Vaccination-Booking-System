package com.example.vaccinationbookingsystem.Model;
import com.example.vaccinationbookingsystem.Enum.CentreType;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaccinationCentre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String centreName;
    String address;
    CentreType centreType;
    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL)
    List<Doctor> doctor= new ArrayList<>();

}
