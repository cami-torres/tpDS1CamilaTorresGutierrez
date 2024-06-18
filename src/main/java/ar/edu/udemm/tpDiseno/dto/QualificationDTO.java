package ar.edu.udemm.tpDiseno.dto;

public class QualificationDTO {
    String username;
    String name;
    String subject;
    Float qualification;

    
   
    public QualificationDTO(String name, String subject, Float qualification) {
        this.username = "";
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
    }

    public QualificationDTO(String username, String name, String subject, Float qualification) {
        this.username = username;
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
    }

    public String getName() {
        return this.name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getQualification() {
        return this.qualification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQualification(Float qualification) {
        this.qualification = qualification;
    }

    public String getUsername() {
        return username;
    }
}
