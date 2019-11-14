package application.controller;

import application.service.FacebookService;
import org.json.JSONObject;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FbController {

    private FacebookService facebookService;
    private ConnectionRepository connectionRepository;

    public FbController(FacebookService facebookService, ConnectionRepository connectionRepository) {
        this.facebookService = facebookService;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/")
    public String generateAuthorization() {
        if(connectionRepository.findPrimaryConnection(Facebook.class) == null){
            return facebookService.generateAuthorization();
        }
        return facebookService.getData();
    }

    @GetMapping("/getToken")
    public void generateAccessToken(@RequestParam("code") String token) {
        facebookService.generateAccessToken(token);
    }

    @GetMapping("/getData")
    public String getUserData() {
        return facebookService.getData();
    }
}