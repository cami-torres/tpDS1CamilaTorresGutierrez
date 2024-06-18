package ar.edu.udemm.tpDiseno.Controller;

import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.User;
import ar.edu.udemm.tpDiseno.Service.PasswordService;
import ar.edu.udemm.tpDiseno.Service.QualificationService;
import ar.edu.udemm.tpDiseno.Service.UserService;
import ar.edu.udemm.tpDiseno.dto.QualificationDTO;
import ar.edu.udemm.tpDiseno.dto.UserDTO;
import ar.edu.udemm.tpDiseno.dto.UserPasswordDTO;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;
    private QualificationService qualificationService;
    private PasswordService passwordService;

    public UserController(UserService userService, QualificationService qualificationService,
            PasswordService passwordService) {
        this.userService = userService;
        this.qualificationService = qualificationService;
        this.passwordService = passwordService;
    }

    @GetMapping({ "/login", "/" })
    public String login(Model model, UserDTO userDTO) {
        model.addAttribute("user", userDTO);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model, UserDTO userDTO) {
        model.addAttribute("user", userDTO);
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") UserDTO userDTO, Model model) {
        User user = userService.findByUsername(userDTO.getUsername());
        if (user != null) {
            model.addAttribute("UserExist", user);
            return "register";
        }
        UserPasswordDTO userPasswordDTO = new UserPasswordDTO(userDTO.getPassword());
        if (!passwordService.isValid(userPasswordDTO)) {
            model.addAttribute("InvalidPwd", true);
            return "register";
        }
        userService.save(userDTO);
        return "redirect:/register?success";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);

        return "home";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file, Model model, Principal principal) throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);

        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();

        if (fileName != null) {
            List<QualificationDTO> qualifications = new ArrayList<>();
            if (fileName.endsWith(".pdf")) {
                qualifications = qualificationService.read(inputStream, FileType.PDF);
            } else if (fileName.endsWith(".csv")) {
                qualifications = qualificationService.read(inputStream, FileType.CSV);
            } else if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
                qualifications = qualificationService.read(inputStream, FileType.EXCEL);
            }
            qualificationService.save(qualifications, userDetails);
            model.addAttribute("qualifications", qualifications);
        }
        return "home";
    }
}
