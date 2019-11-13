package application.service;

import org.json.JSONObject;

public interface FacebookService {
     String generateAuthorization();

     void generateAccessToken(String code);

     String getData();
}
