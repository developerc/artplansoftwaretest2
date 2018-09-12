package ru.artplansoftwaretest2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import ru.artplansoftwaretest2.entity.Attempts;
import ru.artplansoftwaretest2.service.AttemptsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private AttemptsService attemptsService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        List <Attempts> attemptsList;

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        getRedirectStrategy().sendRedirect(request, response, "/failurepg");

        attemptsList = attemptsService.getAllAttempts();
        if (attemptsList.size() == 0){
            Attempts attempts = new Attempts();
            attempts.setTimeMsec(100);
            attempts.setCntAttempts(1);
            attemptsService.addAttempts(attempts);
        }
        System.out.println("error 401 UNAUTHORIZED");
    }


}
