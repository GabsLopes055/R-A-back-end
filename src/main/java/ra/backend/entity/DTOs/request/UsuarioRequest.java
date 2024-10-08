package ra.backend.entity.DTOs.request;

import ra.backend.entity.enums.Role;
import ra.backend.entity.enums.StatusUser;

public class UsuarioRequest {

    private String nomeCompleto;

    private String email;

    private String password;

    private StatusUser statusUsuario = StatusUser.INATIVO;

    private Role permissao = Role.USER;

    public UsuarioRequest(String nomeCompleto, String email, String password, StatusUser statusUsuario, Role permissao) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.statusUsuario = statusUsuario;
        this.permissao = permissao;
    }

    public UsuarioRequest() {
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

    public StatusUser getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUser statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Role getPermissao() {
        return permissao;
    }

    public void setPermissao(Role permissao) {
        this.permissao = permissao;
    }
}

