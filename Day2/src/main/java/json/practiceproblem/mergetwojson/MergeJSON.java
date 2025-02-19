package json.practiceproblem.mergetwojson;

import org.json.JSONObject;

public class MergeJSON {
    public static  void main(String[] args) {
        // JSONObject 1
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("Punch", "1200cc");
        jsonObject1.put("Harrier","3000cc");

        // JSONObject 2
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Safari","3000cc");
        jsonObject2.put("Tiago","1200cc");

        // Merging two objects
        for (String key:jsonObject1.keySet()){
            jsonObject2.put(key,jsonObject1.get(key));
        }

        // Display output
        System.out.println(jsonObject2);
    }
}
