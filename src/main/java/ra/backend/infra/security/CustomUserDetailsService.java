package ra.backend.infra.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado. METODO: loadUserByUsername"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);
    }


}
