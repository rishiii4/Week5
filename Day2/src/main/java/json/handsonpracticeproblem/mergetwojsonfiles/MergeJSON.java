package json.handsonpracticeproblem.mergetwojsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJSON {
    public static void main(String[] args) {
        String path1 = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\mergetwojsonfiles\\file1.json";
        String path2 = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\mergetwojsonfiles\\file2.json";
        String output = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\mergetwojsonfiles\\output.json";
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file
            File file1 = new File(path1);
            JsonNode jsonNode1 = objectMapper.readTree(file1);

            File file2 = new File(path2);
            JsonNode jsonNode2 = objectMapper.readTree(file2);

            // Merge the two JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            // Write the merged JSON to a new file
            File mergedFile = new File(output);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(mergedFile, mergedJson);

            System.out.println("JSON files merged successfully!");
            System.out.println(mergedJson.toPrettyString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
