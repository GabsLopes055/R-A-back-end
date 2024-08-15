package ra.backend.entity.DTOs.response;

public class AuthenticationResponse {

    private String usuario;

    private String token;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
