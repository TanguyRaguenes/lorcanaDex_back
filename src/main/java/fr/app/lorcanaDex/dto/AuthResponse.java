package fr.app.lorcanaDex.dto;

public class AuthResponse {

    private String jwt;

    // Constructeur
    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}