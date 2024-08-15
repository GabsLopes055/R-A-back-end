package ra.backend.services.exceptions;

public class UsuarioInativoService extends RuntimeException {
    public UsuarioInativoService(String mensagem) {
        super(mensagem);
    }
}
