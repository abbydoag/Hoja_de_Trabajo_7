package dictionary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String readDictionary(String dictionaryFile) throws FileNotFoundException {
        BufferedReader dictionaryScan = new BufferedReader(new FileReader("src/dictionary/diccionario.txt"));
        String dictionary = "";

        try {
            dictionary = dictionaryScan.readLine();
            while (dictionary != null) {
                System.out.println(dictionary);
                dictionary = dictionaryScan.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // para quitar el null
        if (dictionary == null) {
            return "";
        }
        System.out.println(dictionary);
        return dictionary;
    }

    public static void main(String[] args) throws FileNotFoundException {
    	Tree tree = new Tree();
    	
        try (BufferedReader br = new BufferedReader(new FileReader("src/dictionary/texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                String word = words[0];
                String translation = words[1];
                tree.insert(word, translation);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        List<String> words = Arrays.asList(tree.getWordsInOrder());
        for (String word : words) {
        	System.out.println(word + " - " + tree.search(word));
        }      
        tree.delete("house");

        List<String> wordsT = Arrays.asList(tree.getWordsInOrder());
        for (String wordT : wordsT) {
            System.out.println(wordT + " - " + ((Node)tree.search(wordT)).getTranslation());
        }
     }
}