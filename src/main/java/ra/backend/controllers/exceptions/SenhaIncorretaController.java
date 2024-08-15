package ra.backend.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ra.backend.controllers.exceptions.exemploExeception.ExcecaoExemplo;
import ra.backend.services.exceptions.SenhaIncorretaService;

import java.time.Instant;

@ControllerAdvice
public class SenhaIncorretaController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SenhaIncorretaService.class)
    public ResponseEntity<ExcecaoExemplo> exceptionSenhaIncorreta(SenhaIncorretaService exception, HttpServletRequest request) {

        ExcecaoExemplo excecaoExemplo = new ExcecaoExemplo();

        excecaoExemplo.setCaminho(request.getRequestURI());
        excecaoExemplo.setMensagem(exception.getMessage());
        excecaoExemplo.setError("Senha incorreta");
        excecaoExemplo.setStatus(HttpStatus.BAD_REQUEST.value());
        excecaoExemplo.setMomentoDaExcecao(Instant.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excecaoExemplo);

    }

}
