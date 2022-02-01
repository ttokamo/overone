package by.overone.it.service;

import by.overone.it.validation.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private RegistrationValidation registrationValidation;

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
