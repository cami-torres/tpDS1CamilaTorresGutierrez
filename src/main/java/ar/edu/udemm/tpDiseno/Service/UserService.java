package ar.edu.udemm.tpDiseno.Service;

import ar.edu.udemm.tpDiseno.Entity.User;
import ar.edu.udemm.tpDiseno.dto.UserDTO;

public interface UserService {
    User findByUsername(String username);

    User save(UserDTO userDTO);

}
