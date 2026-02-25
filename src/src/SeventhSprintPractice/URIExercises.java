package SeventhSprintPractice;
<<<<<<< HEAD

import java.io.IOException;
import java.net.HttpRetryException;
=======
import java.io.IOException;
>>>>>>> ed9b0b4ea0699cd878f0575a00a636c62391031e
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
<<<<<<< HEAD

public class URIExercises {
    public static void main(String[] args) {
        int requestedStatus = 505;
        String url = "http://httpbin.org/status/" + requestedStatus;
        URI uri = URI.create(url);
=======
import java.time.Duration;

public class URIExercises {

    public static void main(String[] args) throws IOException, InterruptedException {
        URI uri = URI.create("https://github.com/orgs/community/discussions/144430");
>>>>>>> ed9b0b4ea0699cd878f0575a00a636c62391031e

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
<<<<<<< HEAD
=======
                .version(HttpClient.Version.HTTP_1_1)
                .header("Accept", "text/html")
>>>>>>> ed9b0b4ea0699cd878f0575a00a636c62391031e
                .build();

        HttpClient client = HttpClient.newHttpClient();

<<<<<<< HEAD
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
=======
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request, handler);

        System.out.println("Код ответа: "  + response.statusCode());
        System.out.println("Тело ответа: " + response.body());

    }

>>>>>>> ed9b0b4ea0699cd878f0575a00a636c62391031e
}
