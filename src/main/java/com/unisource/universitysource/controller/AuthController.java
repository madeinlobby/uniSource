package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.*;
import com.unisource.universitysource.repository.BlackListTokenRepository;
import com.unisource.universitysource.repository.RoleRepository;
import com.unisource.universitysource.service.CustomUserDetailService;
import com.unisource.universitysource.service.UserService;
import com.unisource.universitysource.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BlackListTokenRepository blackListTokenRepository;

    @Autowired
    private CustomUserDetailService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.existUserByUsername(registerRequest.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        User user = new User(registerRequest.getUsername(), encoder.encode(registerRequest.getPassword()), registerRequest.getFirstname(), registerRequest.getLastname());
        Set<String> strRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN).orElseThrow(
                                () -> new RuntimeException("Error: Role is not found.")
                        );
                        roles.add(adminRole);
                        break;
                    case "moderator":
                        Role moderatorRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR).orElseThrow(
                                () -> new RuntimeException("Error: Role is not found.")
                        );
                        roles.add(moderatorRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER).orElseThrow(
                                () -> new RuntimeException("Error: Role is not found.")
                        );
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userService.addUser(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException exception) {
            return ResponseEntity.badRequest().body(new MessageResponse("Bad Credentials entered"));
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/check-username/{username}")
    public Boolean checkUserName(@PathVariable String username) {
        return !userService.existUserByUsername(username);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(value = "Authorization") String token) {
        if (token == null || !token.startsWith("Bearer "))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        if (!jwtUtil.validateToken(jwt, userDetail))
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token sent"));
        BlackListToken blackListToken = new BlackListToken(jwt, jwtUtil.extractExpiration(jwt));
        blackListTokenRepository.save(blackListToken);
        return ResponseEntity.ok(new MessageResponse("logout successfully."));
    }

    @GetMapping("/check-token")
    public Boolean checkTokenValidity(@RequestHeader(value = "Authorization") String token) {
        if (token == null || !token.startsWith("Bearer "))
            return false;
        String jwt = token.substring(7);
        String username = jwtUtil.extractUsername(jwt);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        return jwtUtil.validateToken(jwt, userDetail);
    }
}
