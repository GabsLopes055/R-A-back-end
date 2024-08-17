package ra.backend.entity.DTOs.request;

import ra.backend.entity.DTOs.response.FiltroBusca;
import ra.backend.entity.enums.Role;
import ra.backend.entity.enums.StatusUser;

public class FiltroUsuarioRequest extends FiltroBusca {

    private StatusUser statusUser;
    private String nomeCompleto;
    private String email;
    private Role role;

    public FiltroUsuarioRequest(Integer pagina, Integer tamanhoPagina, StatusUser statusUser, String nomeCompleto, String email, Role role) {
        super(pagina, tamanhoPagina);
        this.statusUser = statusUser;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.role = role;
    }

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(StatusUser statusUser) {
        this.statusUser = statusUser;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
