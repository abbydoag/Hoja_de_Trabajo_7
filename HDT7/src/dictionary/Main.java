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
        BufferedReader dictionaryScan = new BufferedReader(new FileReader(dictionaryFile));
        StringBuilder dictionary = new StringBuilder();

        try {
            String languages = dictionaryScan.readLine();
            while (languages != null) {
                System.out.println(dictionary);
                dictionary.append(languages).append("\n");
                languages= dictionaryScan.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dictionary.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
    	Tree tree = new Tree();
    	
    	try (BufferedReader br = new BufferedReader(new FileReader("src/dictionary/diccionario.txt"))) {
            String line;
            while ((line = br.readLine())!=null){
                String[] words = line.split(",");
                if (words.length >= 2) {
                	String word = words[0];
                    String translation = words[1];
                    tree.insert(word, translation);
                }
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
        	Object result = tree.search(wordT);
        	 if (result != null && result instanceof Node) {
        		 	Node node = (Node) result;
        		 	System.out.println(wordT + " - " + node.getTranslation());
        	    }
        }
     }
}