package utils;

public class Counter {
    private final char[] separators = new char[]{',', '.', ' '};
    private String counterText = null;

    public Counter(String text) {
        counterText = text;
    }

    private boolean isSeparator(char letter) {
        for (char separator : separators) {
            if (letter == separator) {
                return true;
            }
        }

        return false;
    }

    public int countWords() {
        String cleanText = counterText.trim();
        boolean isWord = false;
        int wordsCount = 0;

        for (int i = 0; i < cleanText.length(); i++) {
            char letter = cleanText.charAt(i);
            if (isSeparator(letter) && isWord) { // Don't count consecutive separators as many words
                wordsCount++;
                isWord = false;
            } else {
                isWord = true;
            }
        }
        if (isWord) wordsCount++; // Count last word if it does not end with a separator

        return wordsCount;
    }

    public int countChars() {
        return counterText.length();
    }
}
