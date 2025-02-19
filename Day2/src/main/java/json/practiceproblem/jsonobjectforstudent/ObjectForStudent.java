package json.practiceproblem.jsonobjectforstudent;


import org.json.JSONArray;
import org.json.JSONObject;

public class ObjectForStudent {
    public static void main(String[] args) {
        // JSONObject student
        JSONObject student = new JSONObject();
        student.put("Name", "Rohan");
        student.put("Age", 22);

        // Creating array of subject
        JSONArray subject = new JSONArray();
        subject.put("Maths");
        subject.put("Physics");
        subject.put("Chemistry");

        // Put student info
        student.put("Subjects", subject);
        // Printing student details
        System.out.println(student.toString());

    }
}
