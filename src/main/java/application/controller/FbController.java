package application.controller;

import application.model.UserData;
import application.service.FacebookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public void generateAccessToken(@RequestParam("code") String token) {
        facebookService.generateAccessToken(token);
    }

    @GetMapping("/getData")
    public UserData getUserData() throws IOException {
        return facebookService.getData();
    }
}
