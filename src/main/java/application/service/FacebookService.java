package application.service;

import org.json.JSONObject;
import org.springframework.ui.Model;

public interface FacebookService {
     String generateAuthorization();

     void generateAccessToken(String code);

     String getData();
}
