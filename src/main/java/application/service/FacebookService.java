package application.service;

public interface FacebookService {
     String generateAuthorization();

     void generateAccessToken(String code);

     String getData();
}
