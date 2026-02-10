package SeventhSprintPractice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;



public class HttpServerExercise {
    public static final int PORT = 8080;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.start();
        System.out.println("Server started on port " + PORT);

    }

    public HttpServerExercise() throws IOException {
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println();
            String method = httpExchange.getRequestMethod();
            if (method.equals("GET")) {
                System.out.println("Здравствуйте!");
            } else if(method.equals("POST")) {
                System.out.println("Вы использовали метод POST.");
            }
            else {
                System.out.println("Некорректный метод запроса: " + method);
            }

            System.out.println("Началась обработка /hello " + method + "  запроса от клиента.");


            InputStream requestBody = httpExchange.getRequestBody();
            String body = new String (requestBody.readAllBytes(), DEFAULT_CHARSET);
            System.out.println("Тело запроса: " + body);



            String response = "Началась обработка запроса /hello от клиента!";
            httpExchange.sendResponseHeaders(200, 0);

            Headers requestHeaders = httpExchange.getRequestHeaders();
            System.out.println("Заголовки запроса: " + requestHeaders.entrySet());
            List<String> contentTypeValues = requestHeaders.get("Content-Type");
            if (contentTypeValues != null && (contentTypeValues.contains("application/json"))) {
                System.out.println("Запрос содержит JSON данные.");
            }



            URI requestURI = httpExchange.getRequestURI();
            System.out.println("Запрошенный URI: " + requestURI.toString());
            String path = requestURI.getPath();
            String[] splitStrings = path.split("/");

            String name = splitStrings[2];
            System.out.println("Извлеченное имя из пути: " + name);

            System.out.println("Разделенный путь: " + List.of(splitStrings));
            System.out.println("Количество частей в пути: " + splitStrings.length);
            System.out.println( "getAuthority: " + requestURI.getAuthority());
            System.out.println( "getHost: " + requestURI.getHost());
            System.out.println( "getPort: " + requestURI.getPort());
            System.out.println( "getQuery: " + requestURI.getQuery());
            System.out.println( "getRawPath: " + requestURI.getRawPath());
            System.out.println( "getRawQuery: " + requestURI.getRawQuery());
            System.out.println( "getScheme: " + requestURI.getScheme());


            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(response.getBytes());
            }

        }


    }
}