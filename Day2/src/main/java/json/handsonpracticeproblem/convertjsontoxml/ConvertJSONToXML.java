package json.handsonpracticeproblem.convertjsontoxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.Map;

public class ConvertJSONToXML {
    public static void main(String[] args) {
        String jsonPath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\convertjsontoxml\\data.json";
        String xmlPath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day2\\src\\main\\java\\json\\handsonpracticeproblem\\convertjsontoxml\\converted.xml";
        try {
            File jsonFile = new File(jsonPath);
            File xmlFile = new File(xmlPath);

            // Check if the JSON file exists
            if (!jsonFile.exists()) {
                System.out.println("JSON file does not exist at the specified path.");
                return;
            }

            // Read JSON file into a Java object (Map or POJO)
            ObjectMapper jsonMapper = new ObjectMapper();
            Map<String, Object> jsonData = jsonMapper.readValue(jsonFile, Map.class);

            // Write the Java object to an XML file
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(xmlFile, jsonData);

            System.out.println("JSON converted to XML successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}