package ra.backend.entity.DTOs.response;

import ra.backend.entity.UsuarioEntity;
import ra.backend.entity.enums.USUARIO_ENUM;

public class UsuarioResponse {

    private String userId;

    private String nomeCompleto;

    private String email;

    private String password;

    private USUARIO_ENUM statusUsuario;



    private String permissao;

    public UsuarioResponse toEntity(UsuarioEntity usuarioEntity) {
        return new UsuarioResponse(
                usuarioEntity.getUserId(),
                usuarioEntity.getNomeCompleto(),
                usuarioEntity.getEmail(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatusUsuario(),
                usuarioEntity.getPermissao()
        );
    }

    public UsuarioResponse(String userId, String nomeCompleto, String email, String password, USUARIO_ENUM statusUsuario, String permissao) {
        this.userId = userId;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.password = password;
        this.statusUsuario = statusUsuario;
        this.permissao = permissao;
    }

    public UsuarioResponse() {
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

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
