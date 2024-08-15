package ra.backend.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;
import ra.backend.entity.UsuarioEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

//    @Value("${chave.secret.token.jwt}")
    private String chaveToken = "MINHA_CHAVE_SECRETA";

    Algorithm algorithm = Algorithm.HMAC256(chaveToken);

    public String retornaToken(UsuarioEntity user) {

        try {

            return this.gerarToken(user.getEmail());

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao criar token JWT");
        }
    }

    private String gerarToken(String usuario) {
        return JWT.create().withIssuer("ra-backEnd").withSubject(usuario).withExpiresAt(this.generateExpirationDate()).sign(algorithm);
    }

    public String validarToken(String token) {
        try {

            return JWT.require(algorithm).withIssuer("ra-backEnd").build().verify(token).getSubject();

        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
