package application.controller;

import application.model.UserData;
import application.service.FacebookService;
import com.google.gson.JsonObject;
import org.springframework.social.facebook.api.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
    public List<UserData> getUserData() throws IOException {
        List<UserData> userDataList = Collections.singletonList(facebookService.getData());
        return userDataList;
    }

    @PostMapping("/write")
    public void writeFileToDisk(Object jsonObject) throws IOException {
       FileWriter file = new FileWriter("/Users/Haris/Desktop/file1.txt");
            file.write(String.valueOf(jsonObject));
    }
}
