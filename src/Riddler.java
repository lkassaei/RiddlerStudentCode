/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Lily Kassaei
 */
public class Riddler {

    public String decryptOne(@org.jetbrains.annotations.NotNull String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptOne() function.
        // Go through the encryption
        for (int i = 0; i < encrypted.length(); i++) {
            // Extract the encrypted character
            char encryptedChar = encrypted.charAt(i);
            // Find if the character is upper lower or punctuation to ensure correct shift
            if (encryptedChar >= 'A' && encryptedChar <= 'Z') {
                decrypted += (char)('A' + (encryptedChar - 'A' - 17 + 26) % 26);
            }
            else if (encryptedChar >= 'a' && encryptedChar <= 'z') {
                decrypted += (char)('a' + (encryptedChar - 'a' - 17 + 26) % 26);
            }
            else {
                decrypted += encryptedChar;
            }
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        String str = "";

        // TODO: Complete the decryptTwo() function.
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

        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptThree() function.
        // Take groups of 8, convert binary to ASCII
        for (int i = 0; i < encrypted.length(); i+=8) {
            // Make sure we are in bounds
            if (i <= encrypted.length() - 9) {
                // Take group of 8
                String str = encrypted.substring(i, i + 8);
                // Get base 10 number from the String in base 2
                int num = Integer.parseInt(str, 2);
                // Convert num into ASCII
                char letter = (char)num;
                decrypted += letter;
            }
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.

        for (char c : encrypted.toCharArray()) {
            // This is the Unicode for it but I don't know how to get from Unicode to text or ascii
            String str = Integer.toHexString(c);
            decrypted += str + " ";
        }
        System.out.println(decrypted);
        return decrypted;
    }
}
