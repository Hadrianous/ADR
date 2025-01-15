package api.adr.actions.home;

import api.adr.responders.HomeHTMLResponder;
import io.sentry.Sentry;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAction {

    HomeHTMLResponder responder = new HomeHTMLResponder();

    @GetMapping("/")
    public ResponseEntity<String> home() {
        if (true) {
            Sentry.captureException(new BadRequestException("Paf c'est le giga crash"));
        }
        return responder.response();
    }
}
