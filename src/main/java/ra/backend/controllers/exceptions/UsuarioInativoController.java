package ra.backend.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ra.backend.controllers.exceptions.exemploExeception.ExcecaoExemplo;
import ra.backend.services.exceptions.UsuarioInativoService;
import ra.backend.services.exceptions.UsuarioNaoEncontradoService;

import java.time.Instant;

@ControllerAdvice
public class UsuarioInativoController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioInativoService.class)
    public ResponseEntity<ExcecaoExemplo> usuarioNaoEncontradoException(UsuarioInativoService exception, HttpServletRequest request) {

        ExcecaoExemplo excecaoExemplo = new ExcecaoExemplo();

        excecaoExemplo.setCaminho(request.getRequestURI());
        excecaoExemplo.setMensagem(exception.getMessage());
        excecaoExemplo.setError("Seu usuário esta inativo no sistema. Entre em contato com o administrador !");
        excecaoExemplo.setStatus(HttpStatus.UNAUTHORIZED.value());
        excecaoExemplo.setMomentoDaExcecao(Instant.now());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(excecaoExemplo);

    }

}
