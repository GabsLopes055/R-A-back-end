package ra.backend.entity;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import ra.backend.entity.enums.Role;
import ra.backend.entity.enums.StatusUser;

@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String nomeCompleto;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private StatusUser status = StatusUser.INATIVO;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String nomeCompleto, String email, String password, StatusUser statusUsuario, Role permissao) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.status = statusUsuario;
        this.role = permissao;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StatusUser getStatus() {
        return status;
    }

    public void setStatus(StatusUser status) {
        this.status = status;
    }
}
