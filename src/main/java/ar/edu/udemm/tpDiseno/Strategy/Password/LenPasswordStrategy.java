package ar.edu.udemm.tpDiseno.Strategy.Password;

import org.springframework.stereotype.Service;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

@Service
public class LenPasswordStrategy implements PasswordStrategy {

    @Override
    public boolean validate(UserPasswordDTO userPassword) {
        return userPassword.getPassword().length() >= 8;

    }

}
