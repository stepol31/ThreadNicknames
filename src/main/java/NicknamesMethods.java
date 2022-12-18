import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NicknamesMethods {
    public static AtomicInteger forLength3 = new AtomicInteger();
    public static AtomicInteger forLength4 = new AtomicInteger();
    public static AtomicInteger forLength5 = new AtomicInteger();

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean isTheSameChar(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLettersInAscendingOrder(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void incrementCounter(int textLength) {
        if (textLength == 3) {
            forLength3.getAndIncrement();
        } else if (textLength == 4) {
            forLength4.getAndIncrement();
        } else {
            forLength5.getAndIncrement();
        }
    }

}
