package application.service;

import application.model.UserData;

import java.io.IOException;

public interface FacebookService {
    String generateAuthorization();

    void generateAccessToken(String code);

    UserData getData() throws IOException;
}
