package udana;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")
    public void healthcheck(@RequestParam(name="format", required=true) String format) {
        return;
    }

    @PutMapping(value = "/healthcheck")
    public  HttpStatus healthcheckPut() {
        return HttpStatus.METHOD_NOT_ALLOWED;
    }

    @PostMapping(value = "/healthcheck")
    public HttpStatus healthcheckPost() {
        return HttpStatus.METHOD_NOT_ALLOWED;
    }


    @DeleteMapping(value = "/healthcheck")
    public HttpStatus healthcheckDelete() {
        return HttpStatus.METHOD_NOT_ALLOWED;
    }

}
