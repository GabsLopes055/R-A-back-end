package ra.backend.services.exceptions;

public class SenhaIncorretaService extends RuntimeException{
    public SenhaIncorretaService(String mensagem) {
        super(mensagem);
    }
}
