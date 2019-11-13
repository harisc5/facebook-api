package application.controller;

import application.service.FacebookService;
import org.json.JSONObject;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Place;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        return facebookService.generateAuthorization();
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
