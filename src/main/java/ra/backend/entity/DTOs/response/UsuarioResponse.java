package ra.backend.entity.DTOs.response;

import ra.backend.entity.UsuarioEntity;
import ra.backend.entity.enums.Role;
import ra.backend.entity.enums.StatusUser;
import ra.backend.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {

    private String userId;

    private String nomeCompleto;

    private String email;

    private StatusUser statusUsuario;

    private Role permissao;


    public static UsuarioResponse toEntity(UsuarioEntity usuarioEntity) {
        return new UsuarioResponse(
                usuarioEntity.getUserId(),
                usuarioEntity.getNomeCompleto(),
                usuarioEntity.getEmail(),
                usuarioEntity.getStatus(),
                usuarioEntity.getRole()
        );
    }

    public static List<UsuarioResponse> toListResponse(List<UsuarioEntity> listEntity) {
        return listEntity.stream().map(UsuarioResponse::toEntity).collect(Collectors.toList());
    }

    public UsuarioResponse(String userId, String nomeCompleto, String email, StatusUser statusUsuario, Role permissao) {
        this.userId = userId;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
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
