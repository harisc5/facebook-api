package application.controller;

import application.service.FacebookService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FbController {

    private FacebookService facebookService;

    public FbController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @GetMapping("/")
    public String generateAuthorization() {
        return facebookService.generateAuthorization();
    }

    @GetMapping("/getToken")
    public String generateAccessToken(@RequestParam("code") String token) {
        facebookService.generateAccessToken(token);
        return "index";
    }

    @GetMapping("/getData")
    public String getUserData() {
        return facebookService.getData();
    }
}