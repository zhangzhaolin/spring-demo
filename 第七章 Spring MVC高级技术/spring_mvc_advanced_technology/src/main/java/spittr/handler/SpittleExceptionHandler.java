package spittr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import spittr.exception.SpittleNotFoundException;

@ControllerAdvice
public class SpittleExceptionHandler {

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String spittleNotFoundException(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error/not_found";
    }


}
