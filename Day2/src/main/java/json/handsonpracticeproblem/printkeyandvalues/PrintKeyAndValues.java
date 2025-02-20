package json.handsonpracticeproblem.printkeyandvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class PrintKeyAndValues {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\printkeyandvalues\\data.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Printing key and values
            jsonNode.fields().forEachRemaining(entry -> {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
