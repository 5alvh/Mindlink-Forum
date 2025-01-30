package com.mindlink.forum.models.user;

import com.mindlink.forum.utils.Gender;
import com.mindlink.forum.utils.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor extends User {

    private String specialization;
    private String licenseNumber;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String email, String password, LocalDate dateOfBirth, Gender gender, String specialization, String licenseNumber) {
        super(firstName, lastName, email, password, UserRole.DOCTOR, dateOfBirth, gender);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }
}
