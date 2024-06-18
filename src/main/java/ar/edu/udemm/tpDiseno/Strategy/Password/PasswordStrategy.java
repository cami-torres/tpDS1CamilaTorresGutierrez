package ar.edu.udemm.tpDiseno.Strategy.Password;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

public interface PasswordStrategy {
    public boolean validate(UserPasswordDTO userPassword);
}
