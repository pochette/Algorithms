package SeventhSprintPractice;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class HttpServerExercisePractice {
    public static final int PORT = 8080;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.start();
        System.out.println("Server started on port " + PORT);

    }

    private static String handlePostMethod(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String[] splitStrings = path.split("/");
        String job = splitStrings[2];
        String name = splitStrings[3];
        Headers requestHeaders = httpExchange.getRequestHeaders();
        String bodyGreeting = new String(httpExchange.getRequestBody().readAllBytes(), DEFAULT_CHARSET);
        //Заголовки запроса: [Accept=[*/*], Host=[localhost:8080], User-agent=[insomnia/12.3.1], Content-type=[application/json], Content-length=[6], Wishgoodday=[true]]
        String response ="";

        if (requestHeaders.get("Wishgoodday").equals("true") && bodyGreeting.equals("Доброе утро")) {
            response = bodyGreeting + ", " + job + " " + name + "! Хорошего дня!";
            System.out.println(response);
        } else {
            response = bodyGreeting + ", " + job + " " + name + "!";
            System.out.println(response);
        }
        return response;
    }

    static class HelloHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println();

            URI requestURI = httpExchange.getRequestURI();
            String path = requestURI.getPath();
            String[] splitStrings = path.split("/");

            Headers requestHeaders = httpExchange.getRequestHeaders();


            String method = httpExchange.getRequestMethod();
            String response = "";
            if (method.equals("GET")) {
                response = "Здравствуйте!";
                System.out.println(response);
            } else if (method.equals("POST")) {
                InputStream requestBody = httpExchange.getRequestBody();
                String body = new String(requestBody.readAllBytes(), DEFAULT_CHARSET);
                response = handlePostMethod(httpExchange);
                System.out.println(response);
            } else {
                response = "Некорректный метод запроса: " + method;
                System.out.println(response);
            }

//
//                System.out.println("Началась обработка /hello " + method + "  запроса от клиента.");
//
//
//                System.out.println("Тело запроса: " + (method.equals("POST") ? "(см. логи выше)" : ""));

            httpExchange.sendResponseHeaders(200, 0);


            System.out.println("Заголовки запроса: " + requestHeaders.entrySet());
            List<String> contentTypeValues = requestHeaders.get("Content-Type");
            if (contentTypeValues != null && (contentTypeValues.contains("application/json"))) {
                System.out.println("Запрос содержит JSON данные.");
            }


            System.out.println("Запрошенный URI: " + requestURI.toString());

            String name = splitStrings[2];
            System.out.println("Извлеченное имя из пути: " + name);

            System.out.println("Разделенный путь: " + List.of(splitStrings));
            System.out.println("Количество частей в пути: " + splitStrings.length);
            System.out.println("getAuthority: " + requestURI.getAuthority());
            System.out.println("getHost: " + requestURI.getHost());
            System.out.println("getPort: " + requestURI.getPort());
            System.out.println("getQuery: " + requestURI.getQuery());
            System.out.println("getRawPath: " + requestURI.getRawPath());
            System.out.println("getRawQuery: " + requestURI.getRawQuery());
            System.out.println("getScheme: " + requestURI.getScheme());


            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(response.getBytes());
            }

        }

    }
}
