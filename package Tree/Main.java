package Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // instances of BSTs
        BinarySearchTrees<String> reservedWordsBST = new BinarySearchTrees<>();
        BinarySearchTrees<String> identifiersBST = new BinarySearchTrees<>();

     /**
	* reads Palindrome.java
	* NOTE!!!! 
	* as you can tell, the file path is custom to my machine
	* update the file path for your Palindrome class, or another
	**/
        JavaProgramToBeTested javaProgram = readJavaProgram("C:\\Users\\Default.DESKTOP-JMBKVIA\\Desktop\\Palindrome.java");

        // initializes reservedwords BST
        initializeReservedWords(reservedWordsBST);

        // parses identifiers from Palindrome.java, and adds to identifiers BST
        parseIdentifiers(javaProgram.getContent(), identifiersBST);

        // prints in-order traversal of the reserved words Binary Search Tree
        printInOrderTraversal("In-order traversal of Reserved Words BST:", reservedWordsBST);

        // prints in-order traversal of the identifiers Binary Search Tree
        printInOrderTraversal("\nIn-order traversal of Identifiers BST:", identifiersBST);
    }

    /**
     * initializes reservedwords BST from reservedWords.txt
     * NOTE!!!! 
     * as you can tell, the file path is custom to my machine
     * update the file path to your machine
     **/
    private static void initializeReservedWords(BinarySearchTrees<String> reservedWordsBST) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Default.DESKTOP-JMBKVIA\\Desktop\\reservedWords.txt", StandardCharsets.UTF_8))) {
            reader.lines().map(String::trim).forEach(reservedWordsBST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JavaProgramToBeTested readJavaProgram(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            reader.lines().forEach(line -> contentBuilder.append(line).append("\n"));
	// reads Palindrome.java, and reutrns a JavaProgramToBeTested object from it 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JavaProgramToBeTested(contentBuilder.toString());
    }

    private static void parseIdentifiers(String javaProgramContent, BinarySearchTrees<String> identifiersBST) {
	// parses identfiers from palindrome.java, and adds to BST
        String[] words = javaProgramContent.split("\\W+");
        for (String word : words) {
            // checks if first character is a letter
            if (Character.isLetter(word.charAt(0))) {
                identifiersBST.add(word);
            }
        }
    }

    private static void printInOrderTraversal(String message, BinarySearchTrees<String> bst) {
	// prints in-order traversal
        System.out.println(message);
        bst.inOrderTraversal();
    }
}
