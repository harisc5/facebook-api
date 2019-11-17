package application.controller;

import application.model.UserData;
import application.service.FacebookService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class FbController {

    private FacebookService facebookService;


    public FbController(FacebookService facebookService) {
        this.facebookService = facebookService;
    }

    @GetMapping("/")
    public void generateAuthorization(HttpServletResponse response) throws IOException {
        response.sendRedirect(facebookService.generateAuthentication());
    }

    @GetMapping("/getToken")
    public String generateAccessToken(@RequestParam("code") String token, HttpServletResponse response) throws IOException {
        facebookService.generateAccessToken(token);

        return "Thank you. You can close this windows now.";
    }

    @GetMapping("/getData")
    public List<UserData> getUserData(){
        List<UserData> userDataList = Collections.singletonList(facebookService.getData());
        return userDataList;
    }

    @PostMapping("/write")
    public void writeFileToDisk(@RequestBody UserData userData) throws IOException {
        FileWriter file = new FileWriter("/Users/38761/Desktop/file1.json");
        file.write(String.valueOf(JSONObject.wrap(userData)));
        file.close();
    }
}
