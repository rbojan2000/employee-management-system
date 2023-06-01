package employee.management.system.controller;

import employee.management.system.model.User;
import employee.management.system.dto.UserDTO;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import employee.management.system.service.interfaces.UserService;
import employee.management.system.util.TokenUtils;
import employee.management.system.dto.JwtAuthenticationRequest;
import employee.management.system.dto.UserTokenState;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private SoftwareEngineerService softwareEngineerService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        String salt = userService.getSaltByUserEmail(authenticationRequest.getUsername());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword().concat(salt)));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String accesJwt = tokenUtils.generateAccessToken(user);
        String refreshJwt = tokenUtils.generateRefreshToken(user) ;
        int refreshTokenExpiresIn = tokenUtils.getRefreshTokenExpiresIn();
        int accessTokenExpiresIn = tokenUtils.getAccessTokenExpiresIn();

        UserTokenState userTokenState = new UserTokenState();
        userTokenState.setAccessToken(accesJwt);
        userTokenState.setRefreshToken(refreshJwt);
        userTokenState.setAccessTokenexpiresIn(accessTokenExpiresIn);
        userTokenState.setRefreshTokenexpiresIn(refreshTokenExpiresIn);

        return ResponseEntity.ok(userTokenState);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO registrationRequest) {

        User user = softwareEngineerService.registerEngineer(registrationRequest);
        if(user != null)
            return ResponseEntity.ok("");

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
    }
}

