package pl.edu.pjatk.s17174.tin.webServices.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(99L, "admin",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ADMIN"));
        inMemoryUserList.add(new JwtUserDetails(1L, "Jan",
                "$2a$10$HlsOTQQ4KliP8OhlJMWfveqGGWA8rU5nvR/RNKA.cCdeBZjWs9EuW", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "Roman",
                "$2a$10$HlsOTQQ4KliP8OhlJMWfveqGGWA8rU5nvR/RNKA.cCdeBZjWs9EuW", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(3L, "Kazimierz",
                "$2a$10$HlsOTQQ4KliP8OhlJMWfveqGGWA8rU5nvR/RNKA.cCdeBZjWs9EuW", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(4L, "Piotr",
                "$2a$10$HlsOTQQ4KliP8OhlJMWfveqGGWA8rU5nvR/RNKA.cCdeBZjWs9EuW", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}


