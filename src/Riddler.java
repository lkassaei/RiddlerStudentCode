/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Lily Kassaei
 */
public class Riddler {
    public static final int CAESAR_SHIFT = 17;
    public static final int UNICODE_SHIFT = 9919;
    public static final int ALPHABET_SIZE = 26;
    public static final int BINARY_NUMBER_SIZE = 8;

    // Caesar Cipher
    public String decryptOne(@org.jetbrains.annotations.NotNull String encrypted) {
        // Return nothing if given an empty encryption
        if (encrypted.isEmpty()) {
            return "";
        }

        // Create space for final answer
        String decrypted = "";

        // Go through the encryption and add each correctly shifted char to our final answer
        for (char encryptedChar : encrypted.toCharArray()) {
            decrypted += caesarShiftChar(encryptedChar);
        }

        // Return final answer and print for debugging
        System.out.println(decrypted);
        return decrypted;
    }

    // Function that shifts a char by correct shift and returns it
    public char caesarShiftChar(char encryptedChar) {
        // If char is Uppercase
        if (encryptedChar >= 'A' && encryptedChar <= 'Z') {
            // Shift char within Uppercase ASCII values
            return (char)('A' + (encryptedChar - 'A' - CAESAR_SHIFT + ALPHABET_SIZE) % ALPHABET_SIZE);
        }
        // If char is lowercase
        else if (encryptedChar >= 'a' && encryptedChar <= 'z') {
            // Shift char within Lowercase ASCII values
            return (char)('a' + (encryptedChar - 'a' - CAESAR_SHIFT + ALPHABET_SIZE) % ALPHABET_SIZE);
        }
        // Punctuation remains unchanged
        else {
            return encryptedChar;
        }
    }

    // ASCII number to char cipher
    public String decryptTwo(String encrypted) {
        // Return nothing if given an empty encryption
        if (encrypted.isEmpty()) {
            return "";
        }

        // Create space for final answer and temp string
        String decrypted = "";
        String str = "";

        // Take ASCII equivalent of every num in between the spaces
        for (int i = 0; i < encrypted.length(); i++) {
            // Find first space
            if (encrypted.charAt(i) == ' ') {
                // Keep backtracking from space until another is found
                int start = i - 1;
                while (start >= 0 && encrypted.charAt(start) != ' ') {
                    start--;
                }
                start++;

                // Extract the number
                str = encrypted.substring(start, i);
                if (!str.isEmpty()) {
                    // Convert the string with the number into a real number
                    int num = Integer.parseInt(str);
                    // Convert that number into ASCII
                    char letter = (char)num;
                    decrypted += letter;
                }
            }
        }

        // Return final answer and print for debugging
        System.out.println(decrypted);
        return decrypted;
    }

    // Binary number to char cipher
    public String decryptThree(String encrypted) {
        // Return nothing if given an empty encryption
        if (encrypted.isEmpty()) {
            return "";
        }

        // Create space for final answer
        String decrypted = "";

        // Take groups of 8, convert binary to ASCII
        for (int i = 0; i < encrypted.length(); i+=BINARY_NUMBER_SIZE) {
            // Make sure we are in bounds
            if (i <= encrypted.length() - BINARY_NUMBER_SIZE - 1) {
                // Take group of 8
                String str = encrypted.substring(i, i + BINARY_NUMBER_SIZE);
                // Get base 10 number from the String in base 2
                int num = Integer.parseInt(str, 2);
                // Convert num into ASCII
                char letter = (char)num;
                decrypted += letter;
            }
        }

        // Return final answer and print for debugging
        System.out.println(decrypted);
        return decrypted;
    }

    // Unicode dingbat to char cipher
    public String decryptFour(String encrypted) {
        // Return nothing if given an empty encryption
        if (encrypted.isEmpty()) {
            return "";
        }

        // Create space for final answer
        String decrypted = "";

        for (char c : encrypted.toCharArray()) {
            // Find Unicode number and shift it down into alphabetical values
            int num = c;
            char letter = (char)(num - UNICODE_SHIFT);
            // Add to final answer
            decrypted += letter;
        }

        // Return final answer and print for debugging
        System.out.println(decrypted);
        return decrypted;
    }
}
