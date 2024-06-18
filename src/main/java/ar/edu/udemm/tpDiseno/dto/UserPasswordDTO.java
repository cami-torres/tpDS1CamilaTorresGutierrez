package ar.edu.udemm.tpDiseno.dto;

public class UserPasswordDTO {
    private String password;

    public UserPasswordDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
