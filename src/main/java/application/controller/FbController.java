package application.controller;

import application.model.UserData;
import application.service.FacebookService;
import org.springframework.social.facebook.api.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
public class FbController {

    private FacebookService facebookService;


    public FbController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @GetMapping("/")
    public void generateAuthorization(HttpServletResponse response) throws IOException {
       response.sendRedirect(facebookService.generateAuthorization());
    }

    @GetMapping("/getToken")
    public String generateAccessToken(@RequestParam("code") String token, HttpServletResponse response) throws IOException {
        facebookService.generateAccessToken(token);

        return "Thank you. You can close this windows now.";
    }
    @GetMapping("/getData")
    public UserData getUserData() throws IOException {
        UserData userData =  facebookService.getData();

        return userData;
    }
}
