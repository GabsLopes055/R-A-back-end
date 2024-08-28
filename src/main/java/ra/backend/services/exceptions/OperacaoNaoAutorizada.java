package ra.backend.services.exceptions;

public class OperacaoNaoAutorizada extends RuntimeException{
    public OperacaoNaoAutorizada(String mensagem) {
        super(mensagem);
    }
}
