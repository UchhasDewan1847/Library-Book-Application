package com.agent47.booklibraryapplication.auth;

import com.agent47.booklibraryapplication.configuration.JwtService;
import com.agent47.booklibraryapplication.entity.BookUser;
import com.agent47.booklibraryapplication.entity.Role;
import com.agent47.booklibraryapplication.repository.UserRepository;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public boolean register(RegisterRequest registerRequest) {
        BookUser user= BookUser.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .address(registerRequest.getAddress())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ADMIN)
                .build();
        var u =userRepository.save(user);
        if(u!= null)
            return true;
        else
            return false;

    }
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var userDetails= userRepository.findByEmail(authenticationRequest.getEmail());
        var jwt=jwtService.generateToken(userDetails);
        return new AuthenticationResponse(jwt);

    }
}
