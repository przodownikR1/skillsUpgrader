package pl.java.scalatech.infrastucture.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalErrorHandling {
    private final String MESSAGE ="msg";
    private final MessageSource messageSource;
    public void errorRedirect(Exception e, HttpServletRequest request, HttpServletResponse response, int httpStatus)
            throws IOException {
        log.error("unhandled exception occurred : {} , status : {}", e, httpStatus);
        String errorMessage = messageSource.getMessage("error.accessDenied", null, request.getLocale());
        response.sendError(httpStatus, errorMessage);
    }

  @ExceptionHandler({ Exception.class, RuntimeException.class })
    public String unexpectedException(Model model, Exception e, Locale locale) {
        log.error("unhandled exception occurred : {} ", e);
        model.addAttribute(MESSAGE, messageSource.getMessage("error.unexpectedException", null, locale));
        return "error";
}
}
