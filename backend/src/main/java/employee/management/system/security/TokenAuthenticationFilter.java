package employee.management.system.security;

import employee.management.system.controller.AuthenticationController;
import employee.management.system.util.TokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    protected final Log LOGGER = LogFactory.getLog(getClass());
    private final TokenUtils tokenUtils;
    private final UserDetailsService userDetailsService;

    private final static Logger logger = LogManager.getLogger(AuthenticationController.class);


    public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenHelper;
        this.userDetailsService = userDetailsService;

    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username;
        String authToken = tokenUtils.getToken(request);

            if (authToken != null) {
                username = tokenUtils.getUsernameFromToken(authToken);
                if (username != null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (tokenUtils.validateToken(authToken, userDetails)) {
                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                        authentication.setToken(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
            chain.doFilter(request, response);
    }
}
