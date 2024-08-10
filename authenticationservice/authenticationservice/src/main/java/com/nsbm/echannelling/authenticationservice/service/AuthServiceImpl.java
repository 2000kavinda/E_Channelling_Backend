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
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

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

        Optional<Credential> credentialOptional1 = credentialsRepository.findById(userRequest.getRegNo());
        if (credentialOptional1.isPresent()) {
            return ResponseEntity.badRequest().body("Pre registered id");
        }else
        {
            Optional<Credential> credentialOptional = credentialsRepository.findByEmail(userRequest.getEmail());
            if (credentialOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Pre registered email");
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

                String subject = "Welcome To Echannelling";
                String text = "Dear User,\n\nYour registration was successful.\n\n Here are your account credentials:\n\n Username: "+ userRequest.getEmail()+" \n\n\n\nPassword :"+ userRequest.getPassword()+" \n\nBest regards,\nEchannelling Team";
                emailService.sendEmail(userRequest.getEmail(), subject, text);

                userRequest.setPassword(null);

                return ResponseEntity.ok(userRequest);

            }
        }

            }

    @Override
    public String createVerification(String email) {
        Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
        if (credentialOptional.isPresent()) {
            Credential credential = credentialOptional.get();
            String randomCode = generateRandomCode();
            credential.setCode(randomCode);
            credentialsRepository.save(credential);
            String subject = "Password Reset OTP";
            String text = "Dear user,\n\nWe received a request to reset the password for your" + email +" account.\n\nOTP: "+randomCode+"\n\nBest regards,\n\nEchannelling Team";
            emailService.sendEmail(email, subject, text);
            return "Reset OTP send to the mail";
        } else {
            return "Email not available";
        }
    }

    @Override
    public String updatePassword(String email, String code,String newPassword) {
        Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
        if (credentialOptional.get().getCode().equals(code)) {
            String encodedPassword = passwordEncoder.encode(newPassword);
            Credential credential = credentialOptional.get();
            credential.setPassword(encodedPassword);
            credentialsRepository.save(credential);
            return "Pssword updated successfully";
        } else {
            return "Something went wrong";
        }
    }

    @Override
    public String login(String email, String password) {
        Optional<Credential> credentialOptional = credentialsRepository.findByEmail(email);
        if (credentialOptional.isPresent()) {
            Credential credential = credentialOptional.get();
            if (passwordEncoder.matches(password, credential.getPassword())) {
                return "Logged in";
            } else {
                return "Wrong password";
            }
        } else {
            return "Not an already user, please create an account first";
        }
    }
}
