package SeventhSprintPractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonBuilderExercise {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();

        UserPost userPost = new UserPost("http://localhost:8080/hello", LocalDateTime.now(),
                "256", null, 4);
        String json = gson.toJson(userPost);
        System.out.println(json);


        String userPostJson = gson.toJson(userPost);
        System.out.println(userPostJson);

        String jsonString = "{\"photoUrl\":\"http://localhost:8080/hello\",\"postTime\":{\"date\":{\"year\":2026,\"month\":1,\"day\":25},\"time\":{\"hour\":11,\"minute\":48,\"second\":6,\"nano\":302567200}},\"userId\":\"001\",\"description\":\"Test Description form Json\",\"likesQuantity\":255}";
        Gson gson1 = new Gson();
        UserPost userPostFromJson = gson1.fromJson(jsonString, UserPost.class);
        System.out.println("UserPost from JSON:");
        System.out.println("Photo URL: " + userPostFromJson.getPhotoUrl());
        System.out.println("Post Time: " + userPostFromJson.getPostTime());
        System.out.println("User ID: " + userPostFromJson.getUserId());
        System.out.println("Description: " + userPostFromJson.getDescription());
        System.out.println("Likes Quantity: " + userPostFromJson.getLikesQuantity());

    }
}


class LocalDateAdapter extends TypeAdapter<LocalDateTime> {
    private static final DateTimeFormatter formatterWritter =
            DateTimeFormatter.ofPattern("dd--MM--yyyy 'T' HH:mm:ss");
    private static final DateTimeFormatter formatterReader =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");


    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDate) throws IOException {
        jsonWriter.value(localDate.format(formatterWritter));
    }

    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        return LocalDateTime.parse(jsonReader.nextString(), formatterReader);
    }
}