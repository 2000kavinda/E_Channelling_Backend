package com.nsbm.echannelling.authenticationservice.service;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import com.nsbm.echannelling.authenticationservice.model.Credential;
import com.nsbm.echannelling.authenticationservice.model.Doctor;
import com.nsbm.echannelling.authenticationservice.model.LabPerson;
import com.nsbm.echannelling.authenticationservice.model.Patient;
import com.nsbm.echannelling.authenticationservice.repository.CredentialsRepository;
import com.nsbm.echannelling.authenticationservice.repository.DoctorRepository;
import com.nsbm.echannelling.authenticationservice.repository.LabPersonRepository;
import com.nsbm.echannelling.authenticationservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private LabPersonRepository labPersonRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public void saveUser(UserRequest userRequest) {
        // Save Credential
        Credential credential = new Credential();
        credential.setRegNo(userRequest.getRegNo());
        credential.setEmail(userRequest.getEmail());
        credential.setPassword(userRequest.getPassword());
        credential.setRole(userRequest.getRole());
        credential.setCode(userRequest.getCode());
        credentialsRepository.save(credential);

        // Save the respective role data
        switch (userRequest.getRole()) {
            case "DOCTOR":
                Doctor doctor = new Doctor();
                doctor.setDrRegNo(userRequest.getRegNo());
                doctor.setDrName(userRequest.getDrName());
                doctor.setSpecialize(userRequest.getSpecialize());
                doctor.setType(userRequest.getType());
                doctor.setProfileImage(userRequest.getProfileImage());
                doctor.setDrQualification(userRequest.getDrQualification());
                doctorRepository.save(doctor);
                break;
            case "LAB_PERSON":
                LabPerson labPerson = new LabPerson();
                labPerson.setLPRegNo(userRequest.getRegNo());
                labPerson.setLPName(userRequest.getLPName());
                labPerson.setLabNo(userRequest.getLabNo());
                labPerson.setLPQualification(userRequest.getLPQualification());
                labPersonRepository.save(labPerson);
                break;
            case "PATIENT":
                Patient patient = new Patient();
                patient.setPId(userRequest.getRegNo());
                patient.setPName(userRequest.getPName());
                patient.setBDay(userRequest.getBDay());
                patient.setGender(userRequest.getGender());
                patient.setContact(userRequest.getContact());
                patientRepository.save(patient);
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + userRequest.getRole());
        }

        // Send email
        String subject = "Registration Successful";
        String text = "Dear " + userRequest.getPName() + ",\n\nYour registration was successful.\n\nBest regards,\nThe Team";
        emailService.sendEmail(userRequest.getEmail(), subject, text);
    }
}
