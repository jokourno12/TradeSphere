package com.tradesphere.app.service.impl;

import com.tradesphere.app.constant.ERole;
import com.tradesphere.app.model.entity.AppUser;
import com.tradesphere.app.model.entity.Role;
import com.tradesphere.app.model.entity.Trader;
import com.tradesphere.app.model.entity.User;
import com.tradesphere.app.model.request.AuthRequest;
import com.tradesphere.app.model.response.LoginResponse;
import com.tradesphere.app.model.response.RegisterResponse;
import com.tradesphere.app.repository.UserRepository;
import com.tradesphere.app.security.JwtUtil;
import com.tradesphere.app.service.AuthService;
import com.tradesphere.app.service.RoleService;
import com.tradesphere.app.service.TraderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TraderService traderService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;
    @Override
    @Transactional
    public RegisterResponse registerUser(AuthRequest authRequest) {
        try {
            Role role = roleService.getOrSave(ERole.TRADER);
            List<Role> roles = new ArrayList<>();
            roles.add(role);

            User user = User.builder()
                    .email(authRequest.getEmail())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(roles)
                    .build();
            userRepository.save(user);

            Trader trader = Trader.builder()
                    .firstName(authRequest.getFirstName())
                    .lastName(authRequest.getLastName())
                    .phone(authRequest.getPhone())
                    .address(authRequest.getAddress())
                    .birthDate(authRequest.getBirthDate())
                    .gender(authRequest.getGender())
                    .build();
            traderService.saveTrader(trader);

            return RegisterResponse.builder()
                    .email(user.getEmail())
                    .role(role.getRoleName())
                    .build();
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
    }

    @Override
    public LoginResponse login(AuthRequest authRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail().toLowerCase(),
                    authRequest.getPassword()
            ));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            AppUser appUser = (AppUser) authentication.getPrincipal();
            String token = jwtUtil.generateToken(appUser);

            return LoginResponse.builder()
                    .token(token)
                    .role(appUser.getRole().name())
                    .build();
        }catch (AuthenticationException e){
            System.out.println("Error: " + e.getMessage());
            return LoginResponse.builder()
                    .token("Ini bermasalah")
                    .role("Bermasalah")
                    .build();
        }
    }

}
