package ForthSprintPractice;

import java.net.MalformedURLException;

public class ExceptionsExercises {
    public static void main(String[] args) {
     //  parseUrl("httpasdas");
     //  print(null);
       int a = 1;
       int b = 0;
       System.out.println(a / b);
    }
    public static java.net.URL parseUrl(final String input){
        try {
            return new java.net.URL(input);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void print (final Object o) {
        System.out.println(o.toString());
    }
}
