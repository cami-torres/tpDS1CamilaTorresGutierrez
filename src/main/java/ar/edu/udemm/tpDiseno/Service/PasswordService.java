package ar.edu.udemm.tpDiseno.Service;

import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

public interface PasswordService {
    public boolean isValid(UserPasswordDTO userPasswordDTO);
}
