package hospital.management.system;

import org.json.JSONObject;

public class TestJson {
    public static void main(String[] args) {
        String json = "{\"disease\":\"Flu\",\"department\":\"General Medicine\"}";
        JSONObject obj = new JSONObject(json);
        System.out.println("Disease: " + obj.getString("disease"));
        System.out.println("Department: " + obj.getString("department"));
    }
}
