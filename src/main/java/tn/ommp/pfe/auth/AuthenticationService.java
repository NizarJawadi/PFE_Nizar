package tn.ommp.pfe.auth;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import tn.ommp.pfe.jwt.config.TokenType;
import tn.ommp.pfe.jwt.service.JwtService;
import tn.ommp.pfe.models.Token;
import tn.ommp.pfe.models.User;
import tn.ommp.pfe.repository.TokenRepository;
import tn.ommp.pfe.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	public static final String NOTFOUND = "NOTFOUND";
	private final UserRepository repository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder().matricule(request.getMatricule())
				.password(passwordEncoder.encode(request.getPassword())).role(request.getRole())
				// .role())
				// .password(passwordEncoder.encode(request.getPassword()))

				.build();
		var savedUser = repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(savedUser, jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request, HttpSession session) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getMatricule(), request.getPassword()));
		var user = repository.findByMatricule(request.getMatricule()).orElseThrow(null);
		var jwtToken = jwtService.generateToken(user);
		revokeAllUserTokens(user);
		saveUserToken(user, jwtToken);
		
		User us = repository.findByMatricule(request.getMatricule()).get();
		
		
		session.setAttribute("user", us);
		session.setAttribute("password", user.getPassword());
		session.setAttribute("matricule", user.getMatricule());
		session.setAttribute("role", user.getRole().name());
		session.setAttribute("token", jwtToken);
		session.setAttribute("sessionId", session.getId());
		session.setAttribute("ID", us.getId());
		System.out.println(session.getId());
		HttpStatus status = HttpStatus.ACCEPTED;
		return AuthenticationResponse.builder()
				.ID(us.getId())
				.matricule(user.getMatricule())
				.password(user.getPassword())
				.role(user.getRole().name())
				.sessionID(session.getId())
				.token(jwtToken).build();
	}

	private void saveUserToken(User user, String jwtToken) {
		var token = Token.builder().user(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false).revoked(false)
				.build();
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(User user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}
}