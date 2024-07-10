package net.mohamed.hospital_app.repository;

import net.mohamed.hospital_app.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(String firstName,String lastName, Pageable pageable);
}
