package ra.backend.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ra.backend.controllers.exceptions.exemploExeception.ExcecaoExemplo;
import ra.backend.services.exceptions.EmailJaCadastradoService;

import java.time.Instant;

@ControllerAdvice
public class AcessoNaoAutorizado extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(EmailJaCadastradoService.class)
//    public ResponseEntity<ExcecaoExemplo> usuarioCadastradoException(HttpServletRequest request) {
//
//        ExcecaoExemplo excecaoExemplo = new ExcecaoExemplo();
//
//        excecaoExemplo.setCaminho(request.getRequestURI());
//        excecaoExemplo.setMensagem("Acesso não autorizado");
//        excecaoExemplo.setError("Token não autorizado a realizar esta operação");
//        excecaoExemplo.setStatus(HttpStatus.UNAUTHORIZED.value());
//        excecaoExemplo.setMomentoDaExcecao(Instant.now());
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(excecaoExemplo);
//
//    }

}
