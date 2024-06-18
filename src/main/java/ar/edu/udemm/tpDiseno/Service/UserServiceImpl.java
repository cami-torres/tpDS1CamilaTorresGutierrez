package ar.edu.udemm.tpDiseno.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.udemm.tpDiseno.Entity.User;
import ar.edu.udemm.tpDiseno.Repository.UserRepository;
import ar.edu.udemm.tpDiseno.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getFullname());
        return userRepository.save(user);
    }

}
