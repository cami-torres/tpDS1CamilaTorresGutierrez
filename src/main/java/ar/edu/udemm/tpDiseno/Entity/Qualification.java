package ar.edu.udemm.tpDiseno.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualifications")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String username;
    String name;
    String subject;
    Float qualification;

    public Qualification() {

    }

    

    public Qualification(String name, String subject, Float qualification) {
        this.username = "";
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
    }

    public Qualification(String username, String name, String subject, Float qualification) {
        this.username = username;
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public String getSubject() {
        return this.subject;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Qualification [id=" + id + ", name=" + name + ", subject=" + subject + ", qualification="
                + qualification + "]";
    }
}
