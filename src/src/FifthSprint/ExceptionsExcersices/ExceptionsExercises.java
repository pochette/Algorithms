package FifthSprint.ExceptionsExcersices;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class ExceptionsExercises {
    public static void main(String[] args) throws MalformedURLException, NoSuchElementException {
//        System.out.println(parsStringToUri("http://ya.ru"));
//        System.out.println(parsStringToUri(null));
//        System.out.println(parsStringToUri(":/"));
//
//        System.out.println(addToMap(new HashMap<>(), "test", "test"));
//        System.out.println(addToMap(new HashMap<>(), null, null));
//        System.out.println(addToMap(new TreeMap<>(),"test", "test"));
//        System.out.println(addToMap(new TreeMap<>(), null, null));
//
//        System.out.println(addToMap(Map.of(), "test", "test"));
//        try {
//            calculate();
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            System.out.println(parseIntegerWithOffset("19"));
//        } catch (Exception e) {
//            if (e.getMessage().equals("out of bounds")) {
//                System.out.println("Произошел выход за границы!");
//            }
//        }

        try {
            calculate2();
        } catch (ArithmeticException e) {
            for (StackTraceElement stack : e.getStackTrace()) {
                System.out.println(String.format("Класс: %s, метод: %s, имя файла: %s, строка: %s",
                        stack.getClassName(),
                        stack.getMethodName(),
                        stack.getFileName(),
                        stack.getLineNumber()));
            }
        }
        System.out.println(convertStringToUrl("http://ya.ru"));
        System.out.println("http://ya.ru");

        System.out.println(getRandomValue());;

        final Scanner scanner = new Scanner(new ByteArrayInputStream("hello\nworld".getBytes()));
        try {
            System.out.println("First line: " + scanner.nextLine());
            System.out.println("Second line: " + scanner.nextLine());
            System.out.println("Third line: " + scanner.nextLine());
//        } catch (NoSuchElementException e) {
//            System.out.println("Error: lines are not enough");
        } finally {
            System.out.println("Close scanner");
            scanner.close();
        }

    }
    public class PositivePoints {
        private final int positionX;
        private final int positionY;

        public PositivePoints(int positionX, int positionY) throws IllegalArgumentException {
            if (positionX < 0 || positionY < 0) {
                throw new IllegalArgumentException();
            }
            this.positionX = positionX;
            this.positionY = positionY;
        }

        public int getPositionX() {
            return positionX;
        }
        public int getPositionY() {
            return positionY;
        }

    }

    public static int getRandomValue() {
        int generatedValue = -3;
        try {
            Random random = new Random();
            generatedValue = random.nextInt(100) / random.nextInt(10);
        } catch (Throwable e) {
            generatedValue = -1;
//        } finally {
//            generatedValue = -2;
        }
        return generatedValue;
    }

    public static int getPositiveInteger(final String input)
        throws NumberShouldBePositiveException {
        int value = Integer.parseInt(input);
        if (value < 0) {
            throw new NumberShouldBePositiveException();
        }
        return value;
    }

    static class NumberShouldBePositiveException extends Exception{
        public NumberShouldBePositiveException() {
            super("Число должно быть положительным!");
        }
    }
    public static URL convertStringToUrl(final String input) throws MalformedURLException {
        return new URL(input);
    }



    public static int parseIntegerWithOffset(String input) {
        return Integer.parseInt(input, 10, 12, 10);
    }

    public static void calculate2() {
        calculate();
    }
    public static int calculate() {
        return 10 / 0;
    }

    public static Map<String, Object> addToMap (final Map<String, Object> storage,
                                                final String key, final Object value) {
        try {
            storage.put(key, value);
        } catch (NullPointerException e) {
            System.out.println("реализация не поддерживает неинициализированные объекты");
        } catch (UnsupportedOperationException e) {
            System.out.println("реализация не поддерживает добавление новых объектов");
        } catch (Throwable e) {
            System.out.println("неизвестная ошибка");
        }
        return storage;
    }

    public static URI parsStringToUri(final String input) {
        try {
            return new URI(input);
        } catch (URISyntaxException exp) {
            System.out.println("Неверный синтаксис URI");
        } catch (NullPointerException exp) {
            System.out.println("Реализация не поддерживает неинициализированные объекты");
        } catch (UnsupportedOperationException exp) {
            System.out.println("Реализация не поддерживает добавление новых объектов");
        }



        return null;
    }

    public static java.net.URL parseUrl(final String input) {
        try {
            return new java.net.URL(input);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(final Object o) {
        System.out.println(o.toString());
    }

    class IntegerConverter {
        public static int convert(final String input) {
                return Integer.parseInt(input, 10);
        }

    }
}
