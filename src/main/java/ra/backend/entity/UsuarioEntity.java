package ra.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ra.backend.entity.enums.USUARIO_ENUM;

@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String nomeCompleto;

    private String email;

    private String password;

    private USUARIO_ENUM StatusUsuario;

    private String permissao;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String nomeCompleto, String email, String password, USUARIO_ENUM statusUsuario, String permissao) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.StatusUsuario = statusUsuario;
        this.permissao = permissao;
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

    public USUARIO_ENUM getStatusUsuario() {
        return StatusUsuario;
    }

    public void setStatusUsuario(USUARIO_ENUM statusUsuario) {
        StatusUsuario = statusUsuario;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
