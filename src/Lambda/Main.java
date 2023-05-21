import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word.charAt(0));
        }

        System.out.println(result.toString());
        words.removeIf(word -> word.length() % 2 != 0);
        System.out.println(words);
        }
    }


