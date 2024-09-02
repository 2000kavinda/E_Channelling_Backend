package com.nsbm.echannelling.authenticationservice.service.implementation;

import com.nsbm.echannelling.authenticationservice.dto.UserRequest;
import com.nsbm.echannelling.authenticationservice.model.Credential;
import com.nsbm.echannelling.authenticationservice.model.Doctor;
import com.nsbm.echannelling.authenticationservice.model.LabPerson;
import com.nsbm.echannelling.authenticationservice.model.Patient;
import com.nsbm.echannelling.authenticationservice.repository.CredentialsRepository;
import com.nsbm.echannelling.authenticationservice.repository.DoctorRepository;
import com.nsbm.echannelling.authenticationservice.repository.LabPersonRepository;
import com.nsbm.echannelling.authenticationservice.repository.PatientRepository;
import com.nsbm.echannelling.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
//comment
//impl
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
    private EmailServiceImpl emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String generateRandomCode() {
        Random random = new Random();
        int randomCode = 100000 + random.nextInt(900000);
        return String.valueOf(randomCode);
    }

    @Override
    public ResponseEntity<?> saveUser(UserRequest userRequest) {
        try {

            Optional<Credential> credentialOptional1 = credentialsRepository.findById(userRequest.getRegNo());
            if (credentialOptional1.isPresent()) {
                return ResponseEntity.ok("Pre registered id");
            } else {
                Optional<Credential> credentialOptional = credentialsRepository.findByEmail(userRequest.getEmail());
                if (credentialOptional.isPresent()) {
                    return ResponseEntity.ok("Pre registered email");
                } else {
                    String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
                    Credential credential = new Credential();
                    credential.setRegNo(userRequest.getRegNo());
                    credential.setEmail(userRequest.getEmail());
                    credential.setPassword(encodedPassword);
                    credential.setRole(userRequest.getRole());
                    credential.setCode(userRequest.getCode());
                    credentialsRepository.save(credential);

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
                            labPerson.setLPProfileImage(userRequest.getLPProfileImage());
                            labPersonRepository.save(labPerson);
                            break;
                        case "PATIENT":
                            Patient patient = new Patient();
                            patient.setPId(userRequest.getRegNo());
                            patient.setPName(userRequest.getPName());
                            patient.setBDay(userRequest.getBDay());
                            patient.setGender(userRequest.getGender());
                            patient.setContact(userRequest.getContact());
                            patient.setPProfileImage(userRequest.getPProfileImage());
                            patientRepository.save(patient);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid role: " + userRequest.getRole());
                    }

                    String subject = "Welcome To Echannelling";
                    String text = "Dear User,\n\nYour registration was successful.\n\n Here are your account credentials:\n\n Username: " + userRequest.getEmail() + " \n\nPassword :" + userRequest.getPassword() + " \n\nBest regards,\nEchannelling Team";
                    emailService.sendEmail(userRequest.getEmail(), subject, text);

                    userRequest.setPassword(null);

                    HttpHeaders headers = new HttpHeaders();
                    headers.add("status", "Success");
                    return ResponseEntity
                            .ok()
                            .headers(headers)
                            .body(userRequest);


                }
            }
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }

            }

    @Override
    public ResponseEntity<?> createVerification(String email) {
        try {
            Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
            if (credentialOptional.isPresent()) {
                Credential credential = credentialOptional.get();
                String randomCode = generateRandomCode();
                credential.setCode(randomCode);
                credentialsRepository.save(credential);
                String subject = "Password Reset OTP";
                String text = "Dear user,\n\nWe received a request to reset the password for your" + email + " account.\n\nOTP: " + randomCode + "\n\nBest regards,\n\nEchannelling Team";
                emailService.sendEmail(email, subject, text);

                return ResponseEntity.ok("Reset OTP send to the mail");
            } else {

                return ResponseEntity.ok("Email not available");

            }
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updatePassword(String email, String code,String newPassword) {
        try {
            Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
            if (credentialOptional.get().getCode().equals(code)) {
                String encodedPassword = passwordEncoder.encode(newPassword);
                Credential credential = credentialOptional.get();
                credential.setPassword(encodedPassword);
                credentialsRepository.save(credential);
                return ResponseEntity.ok("Pssword updated successfully");

            } else {

                return ResponseEntity.ok("Something went wrong");
            }
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> login(String email, String password) {
        try {
            Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
            if (credentialOptional.isPresent()) {
                Credential credential = credentialOptional.get();
                if (passwordEncoder.matches(password, credential.getPassword())) {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("status", "Success");
                    if (Objects.equals(credential.getRole(), "DOCTOR")) {
                        headers.add("role", "DOCTOR");
                        return ResponseEntity
                                .ok()
                                .headers(headers)
                                .body(doctorRepository.findById(credential.getRegNo()));

                    } else if (Objects.equals(credential.getRole(), "LAB_PERSON")) {
                        headers.add("role", "LAB_PERSON");
                        return ResponseEntity
                                .ok()
                                .headers(headers)
                                .body(labPersonRepository.findById(credential.getRegNo()));

                    } else if (Objects.equals(credential.getRole(), "PATIENT")) {
                        headers.add("role", "PATIENT");
                        return ResponseEntity
                                .ok()
                                .headers(headers)
                                .body(patientRepository.findById(credential.getRegNo()));
                    } else {
                        return ResponseEntity.ok("Admin logged in");
                    }

                } else {
                    return ResponseEntity.ok("Wrong credentials");
                }
            } else {
                return ResponseEntity.ok("Not an already user, please create an account first");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



