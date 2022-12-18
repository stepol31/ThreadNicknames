import java.util.Random;

public class Main {
    final static int AMOUNT_OF_WORDS = 100_000;
    final static String LETTERS = "abc";
    final static int LENGTH = 3;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[AMOUNT_OF_WORDS];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = NicknamesMethods.generateText(LETTERS, LENGTH + random.nextInt(LENGTH));
        }

        Thread palindrome = new Thread(() -> {
            for (String text : texts) {
                if (NicknamesMethods.isPalindrome(text) && !NicknamesMethods.isTheSameChar(text)) {
                    NicknamesMethods.incrementCounter(text.length());
                }
            }
        });

        Thread theSameChar = new Thread(() -> {
            for (String text : texts) {
                if (NicknamesMethods.isTheSameChar(text)) {
                    NicknamesMethods.incrementCounter(text.length());
                }
            }
        });

        Thread lettersInAscendingOrder = new Thread(() -> {
            for (String text : texts) {
                if (NicknamesMethods.isLettersInAscendingOrder(text) && !NicknamesMethods.isTheSameChar(text)) {
                    NicknamesMethods.incrementCounter(text.length());
                }
            }
        });

        palindrome.start();
        theSameChar.start();
        lettersInAscendingOrder.start();

        theSameChar.join();
        lettersInAscendingOrder.join();
        palindrome.join();

        System.out.println("Красивых слов с длинной 3: " + NicknamesMethods.forLength3);
        System.out.println("Красивых слов с длинной 4: " + NicknamesMethods.forLength4);
        System.out.println("Красивых слов с длинной 5: " + NicknamesMethods.forLength5);
    }
}
