package com.example.vaccinationbookingsystem.Repository;

import com.example.vaccinationbookingsystem.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
