package application;

import application.service.FacebookService;
import org.json.JSONObject;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Place;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FbController {

    private FacebookService facebookService;

    public FbController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @GetMapping
    public List<String> welcome() {
        List<String> urls = new ArrayList<String>();
        urls.add("localhost:8080/authorize");
        urls.add("localhost:8080/getData");

        return urls;
    }

    @GetMapping("/authorize")
    public String generateAuthorization() {
        return facebookService.generateAuthorization();
    }

    @GetMapping("/facebook")
    public void generateAccessToken(@RequestParam("code") String token) {
        facebookService.generateAccessToken(token);
    }

    @GetMapping("/getData")
    public String getData() {
        return facebookService.getData();
    }
}
