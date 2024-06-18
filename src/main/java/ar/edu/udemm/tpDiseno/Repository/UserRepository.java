package ar.edu.udemm.tpDiseno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.udemm.tpDiseno.Entity.User;
import ar.edu.udemm.tpDiseno.dto.UserDTO;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDTO userDTO);
}
