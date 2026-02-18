package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class DataDriven {
    private static JSONObject jsonData;

    static {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(
                    new FileReader("src/main/resources/testData/testData.json"));

            jsonData = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUsername(String userType) {
        JSONObject user = (JSONObject) jsonData.get(userType);
        return (String) user.get("username");
    }

    public static String getPassword(String userType) {
        JSONObject user = (JSONObject) jsonData.get(userType);
        return (String) user.get("password");
    }

}
