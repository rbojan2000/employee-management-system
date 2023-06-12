package employee.management.system.security;

import employee.management.system.util.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger = LogManager.getLogger(RestAuthenticationEntryPoint.class);
    private final TokenUtils tokenUtils;

    public RestAuthenticationEntryPoint(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {


        String ipAddress = request.getRemoteAddr();
        String host = request.getRemoteHost();
        int port = request.getRemotePort();

        logger.warn(
                "User failed to log in from IP: ".concat(ipAddress)
                .concat(" HOST: ").concat(host)
                .concat(" PORT: ").concat(String.valueOf(port))
        );

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
