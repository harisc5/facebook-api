package application.service;

import application.model.UserData;

import java.io.IOException;
import java.util.List;

public interface FacebookService {
    String generateAuthorization();

    void generateAccessToken(String code);

    UserData getData();
}
