package needsOrganize;


        // Java 객체 생성
//        Person person = new Person("John", 30);
//
//        // Gson 객체 생성
//        Gson gson = new Gson();
//
//        // Java 객체를 JSON 문자열로 변환
//        String json = gson.toJson(person);
//
//        // JSON 데이터를 파일에 저장
//        try (FileWriter writer = new FileWriter("C:/Users/sdedu/Desktop/person.json")) {
//            writer.write(json);
//            System.out.println("JSON 데이터가 파일에 저장되었습니다.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

import java.io.FileReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CreateJsonUsingGson {
    public static void main(String[] args) {
        String filePath = "C:/Users/sdedu/Desktop/person.json";

        try (FileReader reader = new FileReader(filePath)) {
            // JSON 파일을 JsonElement로 파싱
            JsonElement jsonElement = JsonParser.parseReader(reader);

            // 필요한 키 또는 경로로 접근
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            int age = jsonObject.get("age").getAsInt();
            JsonObject address = jsonObject.getAsJsonObject("address");
            String street = address.get("street").getAsString();
            address.remove("city");
            address.addProperty("city", "성남");
            String city = address.get("city").getAsString();
            // 값 출력
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

