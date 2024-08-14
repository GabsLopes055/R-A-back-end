package ra.backend.entity.DTOs.request;

import ra.backend.entity.enums.USUARIO_ENUM;

public class UsuarioRequest {

    private String nomeCompleto;

    private String email;

    private String password;

    private USUARIO_ENUM statusUsuario;

    private String permissao;

    public UsuarioRequest(String nomeCompleto, String email, String password, USUARIO_ENUM statusUsuario, String permissao) {
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

    public USUARIO_ENUM getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(USUARIO_ENUM statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}

