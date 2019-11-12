package application;

import org.json.JSONObject;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class FbController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public FbController(Facebook facebook, ConnectionRepository connectionRepository){
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }
}
