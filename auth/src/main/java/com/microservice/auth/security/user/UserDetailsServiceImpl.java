package com.microservice.auth.security.user;

import com.microservice.core.model.ApplicationUser;
import com.microservice.core.repository.ApplicationUserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Searching in the BD the user by username '{}'", username);
        ApplicationUser applicationUser = userRepository.findByUsername(username);
        log.info("Application user found '{}'", applicationUser);

        if(applicationUser == null){
            throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));
        }
        return new CustomUserDetails(applicationUser);
    }

    private final class CustomUserDetails extends ApplicationUser implements UserDetails{

        CustomUserDetails(@NotNull ApplicationUser applicationUser) {
            super(applicationUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
