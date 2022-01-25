package by.overone.it.service;

import by.overone.it.validation.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    private RegistrationValidation registrationValidation;

    @Autowired
    public ValidationService(RegistrationValidation registrationValidation) {
        this.registrationValidation = registrationValidation;
    }

    public List<String> registrationValidation(
            String email,
            String password,
            String repassword,
            String firstName,
            String secondName,
            String telephone
    ) {
        return registrationValidation.checkCanUserRegister(email, password, repassword, firstName, secondName, telephone);
    }
}
