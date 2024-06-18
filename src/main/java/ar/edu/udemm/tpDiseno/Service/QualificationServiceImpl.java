package ar.edu.udemm.tpDiseno.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ar.edu.udemm.tpDiseno.Entity.FileType;
import ar.edu.udemm.tpDiseno.Entity.Qualification;
import ar.edu.udemm.tpDiseno.Repository.QualificationRepository;
import ar.edu.udemm.tpDiseno.Strategy.File.FileStrategy;
import ar.edu.udemm.tpDiseno.dto.QualificationDTO;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;
    private final Map<FileType, FileStrategy> strategyByFileType;

    public QualificationServiceImpl(List<FileStrategy> fileStrategies) {
        this.strategyByFileType = fileStrategies
                .stream()
                .collect(Collectors.toMap(FileStrategy::getFileType, Function.identity()));

    }

    @Override
    public List<QualificationDTO> save(List<QualificationDTO> qualificationsdto, UserDetails userDetails) throws Exception {
        
        List<Qualification> qualifications = qualificationsdto
                .stream()
                .map(q -> new Qualification(userDetails.getUsername(), q.getName(), q.getSubject(), q.getQualification()))
                .limit(3)
                .toList();
        return this.qualificationRepository
                .saveAll(qualifications)
                .stream()
                .map(q -> new QualificationDTO(q.getUsername(), q.getName(), q.getSubject(), q.getQualification()))
                .toList();
    }

    @Override
    public List<QualificationDTO> listByUsername(UserDetails userDetail) throws Exception {
        return this.qualificationRepository
                .findAllByUsername(userDetail.getUsername())
                .stream()
                .map(q -> new QualificationDTO(q.getUsername(), q.getName(), q.getSubject(), q.getQualification()))
                .toList();
    }

    @Override
    public List<QualificationDTO> read(InputStream inputStream, FileType fileType) throws Exception {
       return this.strategyByFileType
        .get(fileType)
        .parse(inputStream)
        .stream()
        .map(q -> new QualificationDTO(q.getName(), q.getSubject(), q.getQualification()))
        .toList();
    }
}
