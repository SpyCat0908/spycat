package Araiguma.SpyCat.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Araiguma.SpyCat.Models.RefreshToken;
import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Services.RefreshTokenService;
import Araiguma.SpyCat.Services.TokenService;
import Araiguma.SpyCat.dtos.RefreshTokenDTO;
import Araiguma.SpyCat.dtos.TokenDTO;
import Araiguma.SpyCat.dtos.UserLoginInputDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class LoginController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid UserLoginInputDTO dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                dados.email(),
                dados.password());
        var authentication = manager.authenticate(authenticationToken);
        var token = tokenService.gerarToken((UserDetails) authentication.getPrincipal());
        var user = (UserDetails) authentication.getPrincipal();
        var refreshToken = refreshTokenService.createRefreshToken(user, token);
        return new ResponseEntity<TokenDTO>(
                new TokenDTO(token, refreshToken.getRefreshToken(), user.getUsername()),
                HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenDTO> refreshtoken(@Valid @RequestBody RefreshTokenDTO request) {
        String requestRefreshToken = request.refreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> getToken(requestRefreshToken, user))
                .orElseThrow(() -> new RuntimeException("Refresh token is not in database!"));
    }

    private ResponseEntity<TokenDTO> getToken(String requestRefreshToken, User usuario) {
        String token = tokenService.gerarToken(usuario);
        refreshTokenService.deleteByUser(usuario);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(usuario, token);
        return ResponseEntity.ok(new TokenDTO(token, refreshToken.getRefreshToken(), usuario.getEmail()));
    }

    @DeleteMapping("/revoke")
    public ResponseEntity<?> revokeToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var usuario = (User) auth.getPrincipal();
        refreshTokenService.deleteByUser(usuario);
        return ResponseEntity.noContent().build();
    }
}
