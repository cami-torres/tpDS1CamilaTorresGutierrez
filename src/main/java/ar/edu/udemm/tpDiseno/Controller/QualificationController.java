package ar.edu.udemm.tpDiseno.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.udemm.tpDiseno.Service.QualificationService;
import ar.edu.udemm.tpDiseno.dto.QualificationDTO;

@Controller
public class QualificationController {
  @Autowired
  private UserDetailsService userDetailsService;
  private QualificationService qualificationService;
  
  public QualificationController(QualificationService qualificationService) {
    this.qualificationService = qualificationService;

  }

  @GetMapping("/qualifications")
  public String listQualifications(Model model, Principal principal) throws Exception {
    UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
    model.addAttribute("userdetail", userDetails);

    List<QualificationDTO> qualifications = qualificationService.listByUsername(userDetails);
    model.addAttribute("qualifications", qualifications);
    
    return "qualifications";
  }
}
