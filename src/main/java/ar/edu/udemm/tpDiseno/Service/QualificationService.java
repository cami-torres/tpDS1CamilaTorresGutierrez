package ar.edu.udemm.tpDiseno.Service;

import java.io.InputStream;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.dto.QualificationDTO;

public interface QualificationService {
    public List<QualificationDTO> save(List<QualificationDTO> qualifications, UserDetails userDetails) throws Exception;

    public List<QualificationDTO> listByUsername(UserDetails userDetail) throws Exception;

    public List<QualificationDTO> read(InputStream inputStream, FileType fileType) throws Exception;
}
