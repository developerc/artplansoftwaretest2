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
import java.util.Date;
import java.util.List;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private AttemptsService attemptsService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        List <Attempts> attemptsList;
        Attempts attempts;
        Date date;

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        getRedirectStrategy().sendRedirect(request, response, "/failurepg");

        attemptsList = attemptsService.getAllAttempts();
        if (attemptsList.size() == 0){
            date = new Date();
            attempts = new Attempts();
            attempts.setTimeMsec(date.getTime());
            attempts.setCntAttempts(1);
            attemptsService.addAttempts(attempts);
        } else {
            long cntAtt;
            attempts = attemptsList.get(0);
            cntAtt = attempts.getCntAttempts();
            cntAtt++;
            attempts.setCntAttempts(cntAtt);
            attemptsService.updAttempts(attempts);
        }
        System.out.println("error 401 UNAUTHORIZED");
    }


}
