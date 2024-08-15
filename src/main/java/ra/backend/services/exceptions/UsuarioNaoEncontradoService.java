package ra.backend.services.exceptions;

public class UsuarioNaoEncontradoService extends RuntimeException{

    public UsuarioNaoEncontradoService(String mensagem) {
        super(mensagem);
    }

}
