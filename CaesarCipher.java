import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        String message = "";
        String encryptedMessage = "";
        String decryptedMessage = "";

        // Prompt the user for input
        System.out.print("Enter a message to encrypt: ");
        message = scanner.nextLine();

        System.out.print("Enter a key (1-25): ");
        key = scanner.nextInt();

        // Encrypt the message using the Caesar Cipher
        encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decrypt the message using the same key
        decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) (((int) c + key - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) (((int) c + key - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) (((int) c - key - 65 + 26) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) (((int) c - key - 97 + 26) % 26 + 97);
                result.append(ch);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
