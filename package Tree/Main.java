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
         * NOTE!!!! as you can tell, the file path is custom to my machine update the file path for your Palindrome class, or another
         **/
        JavaProgramToBeTested javaProgram = readJavaProgram("C:\\Users\\Default.DESKTOP-JMBKVIA\\Desktop\\Palindrome.java");

        // initializes reservedwords BST
        initializeReservedWords(reservedWordsBST);

        // parses identifiers from Palindrome.java, and adds to identifiers BST
        parseIdentifiers(javaProgram.getContent(), identifiersBST, reservedWordsBST);

        // prints in-order traversal of the reserved words Binary Search Tree
        printInOrderTraversal("In-order traversal of Reserved Words BST:", reservedWordsBST);

        // prints in-order traversal of the identifiers Binary Search Tree
        printInOrderTraversal("\nIn-order traversal of Identifiers BST:", identifiersBST);
    }

    /**
     * initializes reservedwords BST from reservedWords.txt
     * NOTE!!!! as you can tell, the file path is custom to my machine update the file path to your machine
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
            // reads Palindrome.java, and returns a JavaProgramToBeTested object from it
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JavaProgramToBeTested(contentBuilder.toString());
    }

    private static void parseIdentifiers(String javaProgramContent, BinarySearchTrees<String> identifiersBST, BinarySearchTrees<String> reservedWordsBST) {
        // parses identifiers from palindrome.java, and adds to BST
        String[] words = javaProgramContent.split("\\W+");
        for (String word : words) {
            // checks if it is a valid Java identifier or an integer and not in reservedWordsBST
            if ((isValidJavaIdentifier(word) || isInteger(word)) && !reservedWordsBST.contains(word)) {
                identifiersBST.add(word);
            }
        }
    }

    private static boolean isValidJavaIdentifier(String str) {
        // checks if the given string is a valid Java identifier
        if (str.isEmpty() || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInteger(String str) {
        // checks if the given string is an integer
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printInOrderTraversal(String message, BinarySearchTrees<String> bst) {
        // prints in-order traversal
        System.out.println(message);
        bst.inOrderTraversal();
    }
}
