package ra.backend.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ra.backend.controllers.exceptions.exemploExeception.ExcecaoExemplo;
import ra.backend.services.exceptions.EmailJaCadastrado;

import java.time.Instant;

@ControllerAdvice
public class EmailJaExisteCadastrado extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailJaCadastrado.class)
    public ResponseEntity<ExcecaoExemplo> usuarioCadastradoException(EmailJaCadastrado exception, HttpServletRequest request) {

        ExcecaoExemplo excecaoExemplo = new ExcecaoExemplo();

        excecaoExemplo.setCaminho(request.getRequestURI());
        excecaoExemplo.setMensagem(exception.getMessage());
        excecaoExemplo.setError("Erro ao cadastrar usuario");
        excecaoExemplo.setStatus(HttpStatus.BAD_REQUEST.value());
        excecaoExemplo.setMomentoDaExcecao(Instant.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excecaoExemplo);

    }

}
