package SeventhSprintPractice;

import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class URIExercises {
    public static void main(String[] args) {
        int requestedStatus = 505;
        String url = "http://httpbin.org/status/" + requestedStatus;
        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if (status >= 200 && status <= 299) {
                System.out.println("Сервер успешно обработал запрос. код состояния - " + status);
                return;

            }
            if (status >= 300 && status <= 399) {
                System.out.println("Сервер сообщил о проблеме с запросом. Код состояния  - " + status );
                return;
            }
            if (status >= 400 && status <= 499) {
                System.out.println("Ошибка на стороне клиента. Код ошибки - " + status );
                return;
            }
            if (status >= 500 && status <= 599) {
                System.out.println("Ошибка на стороне сервера. КОд запроса - " + status);
            }

        } catch (IOException e) {
            System.out.println("Во время выполения возникла ошибка. Проверьте, пожалуйста, URL адресс и повторите попытку");;
        } catch (InterruptedException e) {
            System.out.println("Введенный вами адрес не соответствет формату URL");;
        }

    }
}
