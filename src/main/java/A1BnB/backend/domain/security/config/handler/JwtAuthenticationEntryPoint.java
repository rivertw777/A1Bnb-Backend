package A1BnB.backend.domain.security.config.handler;

import static A1BnB.backend.domain.security.exception.constants.SecurityExceptionMessages.LOGIN_FAILED;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import A1BnB.backend.domain.security.config.utils.ResponseWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private final ResponseWriter responseWriter;
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //responseWriter.writeErrorResponse(response, SC_UNAUTHORIZED, LOGIN_FAILED.getMessage());
    }
}