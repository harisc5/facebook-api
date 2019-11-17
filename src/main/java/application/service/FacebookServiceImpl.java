package application.service;

import application.model.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImpl implements FacebookService {

    private String access_token;

    @Value("${spring.social.facebook.app-id}")
    private String appId;

    @Value("${spring.social.facebook.app-secret}")
    private String appSecret;

    private FacebookConnectionFactory createConnection() {
        return new FacebookConnectionFactory(appId, appSecret);
    }

    @Override
    public String generateAuthentication() {
        OAuth2Parameters parameters = new OAuth2Parameters();
        parameters.setRedirectUri("http://localhost:8080/getToken");
        parameters.setScope("email");
        return createConnection().getOAuthOperations().buildAuthenticateUrl(parameters);
    }

    @Override
    public void generateAccessToken(String token) {
        access_token = createConnection().getOAuthOperations()
                .exchangeForAccess(token, "http://localhost:8080/getToken", null)
                .getAccessToken();
    }

    @Override
    public UserData getData() {
        Facebook facebook = new FacebookTemplate(access_token);
        String[] fields = {"id", "name", "gender", "birthday"};
        UserData userData = facebook.fetchObject("me", UserData.class, fields);

        return userData;
    }
}
