package api.intranet.actions.home;

import api.intranet.responders.HomeHTMLResponder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAction {

    HomeHTMLResponder responder = new HomeHTMLResponder();

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return responder.response();
    }
}
