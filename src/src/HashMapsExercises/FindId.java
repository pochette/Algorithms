package HashMapsExercises;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindId {

    private static final Map<Long, User> users = new HashMap();

    public static void main(String[] args) {

// создадим 10 миллион пользователей

        for (long i = 1; i <= 1_000_000L; i++) {

            users.put(i, new User(i, "Имя " + i));

        }

        final long startTime = System.nanoTime();


        User user = findUser(378_366L);

        final long endTime = System.nanoTime();

        System.out.println("Найден пользователь: " + user);

        System.out.println("Поиск занял " + (endTime - startTime)  + " наносекунд.");

    }

    private static User findUser(Long userId) {

        User user = users.get(userId);
        return user;

//        for (User user : users) {
//
//            if (user.id.equals(userId)) {
//
//                return user;
//
//            }
//
//        }
//                          6592400
                            //21400
//        return null;

    }

    static class User {

        Long id;

        String name;

        public User(Long id, String name) {

            this.id = id;

            this.name = name;

        }

        public String toString() {

            return "User{id=" + id + ", name='" + name + "'}";

        }

    }

}