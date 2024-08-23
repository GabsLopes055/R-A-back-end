package ra.backend.services.exceptions;

public class EntityNaoEncontrada extends RuntimeException{

    public EntityNaoEncontrada(String mensagem) {
        super(mensagem);
    }

}
