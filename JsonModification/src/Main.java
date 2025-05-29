import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {

        String path = "resource/data.json"; // Path to your JSON file
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject json = new JSONObject(content);

        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "raaj");
        updates.put("experience", 5);


        JsonFiledUpdate.updateFields(json, updates);


        Files.write(Paths.get(path), json.toString(2).getBytes());
        System.out.println(" JSON updated successfully.");
    }
}
