package ru.artplansoftwaretest2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private AttemptsService attemptsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        List<Attempts> attemptsList;
        Attempts attempts;
        long idAttempts;
        Date date;
        long timeNow;

       attemptsList = attemptsService.getAllAttempts();
        if (attemptsList.size() > 0) {
        attempts = attemptsList.get(0);

        date = new Date();
        timeNow = date.getTime();
        if ((attempts.getCntAttempts() > 1) && ((timeNow - attempts.getTimeMsec()) < 120000)) {
            getRedirectStrategy().sendRedirect(request, response, "/logout");
        } else {
            idAttempts = attempts.getId();
            System.out.println("idAttempts=" + idAttempts);
            attemptsService.deleteAttempts(idAttempts);
            response.setStatus(HttpServletResponse.SC_OK);
            getRedirectStrategy().sendRedirect(request, response, "/pet");
            System.out.println("200 Athentication success!");
        }
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            getRedirectStrategy().sendRedirect(request, response, "/pet");
            System.out.println("200 Athentication success!");
        }


    }
}
