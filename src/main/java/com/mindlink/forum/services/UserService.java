package com.mindlink.forum.services;

import com.mindlink.forum.models.user.userDtos.DoctorRegistrationRequest;
import com.mindlink.forum.models.user.userDtos.PatientRegistrationRequest;

public interface UserService {
    void createPatient(PatientRegistrationRequest patientRegistrationRequest);
    void createDoctor(DoctorRegistrationRequest doctorRegistrationRequest);
}
