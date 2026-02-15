package SeventhSprintPractice;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ParametersInURL {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://api.agify.io?name=Pixel");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Код ответа: " + response.statusCode());
            System.out.println("Тело ответа: " + response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Произошла ошибка при отправке запроса: " + e.getMessage());
            System.out.println("Во время выполнения запроса ресурса по url-адресу: " + uri);
        }
    }
}
