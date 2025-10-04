package FifthSprint;

public class Strings {
    public static boolean onlySingleSubstring(String initialString, String substring) {
        return initialString.indexOf(substring) == initialString.lastIndexOf(substring);
    }

    public static void main(String[] args) {
//        var example = onlySingleSubstring("one, two, three, one, four", "one");
//        var example2 = onlySingleSubstring("one, two, three", "one");
//        System.out.println(example);
//        System.out.println(example2);
//
//        String text = "one, two, three, one, four";
//        System.out.println(text.substring(12, 15));
//        System.out.println(CardNumberMasker.maskCardNumber("4766 3000 4756 2872"));
//


//        greeting = greeting.replace("world", "java");
//        System.out.println(greeting);

        String string = new String("just a string");
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(", world!");
        System.out.println(builder);


    }
    public class CardNumberMasker  {
        public static String maskCardNumber(String cardNumber) {
            String temp = cardNumber.replaceAll(" ", "");
            return temp.substring(0, 4) + " **** **** " +
                    temp.substring((temp.length() - 5), temp.length() - 1);
        }
    }

    public class FindRepeat {
        public static int numberOfRepeat (String text, String substring) {
            int count = 0;
            while (text.contains(substring)) {
                count++;
                text = text.substring(text.indexOf(substring), substring.length());
            }
            return count;
        }
    }

}
