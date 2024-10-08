package ra.backend.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ra.backend.controllers.exceptions.exemploExeception.ExcecaoExemplo;
import ra.backend.services.exceptions.EntityNaoEncontrada;

import java.time.Instant;

@ControllerAdvice
public class EntidadeNaoEncontradoController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNaoEncontrada.class)
    public ResponseEntity<ExcecaoExemplo> usuarioNaoEncontradoException(EntityNaoEncontrada exception, HttpServletRequest request) {

        ExcecaoExemplo excecaoExemplo = new ExcecaoExemplo();

        excecaoExemplo.setCaminho(request.getRequestURI());
        excecaoExemplo.setMensagem(exception.getMessage());
        excecaoExemplo.setError("Entidade não encontrado na base de dados");
        excecaoExemplo.setStatus(HttpStatus.NOT_FOUND.value());
        excecaoExemplo.setMomentoDaExcecao(Instant.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excecaoExemplo);

    }

}
