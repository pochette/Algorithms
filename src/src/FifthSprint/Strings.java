package FifthSprint;

public class Strings {
    public static boolean onlySingleSubstring(String initialString, String substring) {
        return initialString.indexOf(substring) == initialString.lastIndexOf(substring);
    }

    public static void main(String[] args) {
        var example = onlySingleSubstring("one, two, three, one, four", "one");
        var example2 = onlySingleSubstring("one, two, three", "one");
        System.out.println(example);
        System.out.println(example2);

        String text = "one, two, three, one, four";
        System.out.println(text.substring(12, 15));
        System.out.println(CardNumberMasker.maskCardNumber("4766 3000 4756 2872"));
    }
    public class CardNumberMasker  {
        public static String maskCardNumber(String cardNumber) {
            String temp = cardNumber.replaceAll(" ", "");
            return temp.substring(0, 4) + " **** **** " +
                    temp.substring((temp.length() - 5), temp.length() - 1);
        }
    }
}
