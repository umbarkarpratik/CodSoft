package CodSoft;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");
        int option = scanner.nextInt();

        String inputText = "";

        if (option == 1) {
            scanner.nextLine(); // Consume the previous newline character
            System.out.println("Enter the text:");
            inputText = scanner.nextLine();
        } else if (option == 2) {
            scanner.nextLine(); // Consume the previous newline character
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            inputText = readFromFile(filePath);
        } else {
            System.out.println("Invalid option selected.");
            return;
        }

        int wordCount = countWords(inputText);
        System.out.println("Word count: " + wordCount);

        // Count and display the frequency of each word
        Map<String, Integer> wordFrequency = countWordFrequency(inputText);
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } finally {
            reader.close();
        }
        return sb.toString();
    }

    private static int countWords(String inputText) {
        String[] words = inputText.split("\\s+");
        return words.length;
    }

    private static Map<String, Integer> countWordFrequency(String inputText) {
        String[] words = inputText.split("\\s+|[^\\w']+"); // Split by spaces and punctuation
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase(); // Convert to lowercase to ignore case sensitivity
              System.out.println(wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1)); 
            }
        }
        return wordFrequency;
    }
}
