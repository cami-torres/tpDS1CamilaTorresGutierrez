package ar.edu.udemm.tpDiseno.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.udemm.tpDiseno.Strategy.Password.PasswordStrategy;
import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

@Service
public class PasswordServiceImpl implements PasswordService {
    private List<PasswordStrategy> passwordStrategy;

    public PasswordServiceImpl(List<PasswordStrategy> passwordStrategy) {
        this.passwordStrategy = passwordStrategy;
    }

    @Override
    public boolean isValid(UserPasswordDTO userPasswordDTO) {
        boolean isValid = true;
        for (PasswordStrategy ps : passwordStrategy) {
            isValid = isValid && ps.validate(userPasswordDTO);
        }
        return isValid;
    }
}
