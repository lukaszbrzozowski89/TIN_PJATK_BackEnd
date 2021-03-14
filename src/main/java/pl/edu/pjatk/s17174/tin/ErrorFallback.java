package pl.edu.pjatk.s17174.tin;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorFallback implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> genericErrorHandler() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Coś poszło nie tak");
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
