package json.practiceproblem.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class ValidateJSON {
    public static void main(String[] args) throws Exception{
        // Path of json schema
        String schemaPath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\practiceproblem\\validatejson\\schema.json";

        // File path
        String filePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\practiceproblem\\validatejson\\details.json";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        // Load JSON Data
        JsonNode jsonNode = objectMapper.readTree(new File(filePath));

        // Validate JSON
        if(schema.validate(jsonNode).isSuccess()){
            System.out.println("JSON is valid!");
        }else {
            System.out.println("Invalid JSON!");
        }
    }
}
