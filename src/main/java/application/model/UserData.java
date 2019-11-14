package application.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class UserData {
    String id;
    String name;
    String gender;
    String birthday;
    JsonNode location;
}
