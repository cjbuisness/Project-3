package Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Parser {
    // BSTs for identifiers & reversed words
    private final BinarySearchTrees<String> reservedWordsBST;
    private final BinarySearchTrees<String> identifiersBST;

    public Parser() {
	// initializes BSTs
        this.reservedWordsBST = new BinarySearchTrees<>();
        this.identifiersBST = new BinarySearchTrees<>();
    }

    public void initializeReservedWords(String filePath) {
	// initializes reservedwords BST from Palindrome.java
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            // reads each line from the file
            reader.lines().map(String::trim).forEach(reservedWordsBST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sets up balanced BST from reversed words
        setBalancedBST(reservedWordsBST.getRootNode());
    }

    public void getIdentifiers(JavaProgramToBeTested javaProgram) {
	//extracts identifiers from Palindrome.java
        StringTokenizer tokenizer = new StringTokenizer(javaProgram.getContent(), " \t\n\r\f(){}[];,.+-*/%=<>!&|^~", true);
	//tokenizes without regard for " \t\n\r\f(){}[];,.+-*/%=<>!&|^~"

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            // checks if token starts with a letter
            if (Character.isLetter(token.charAt(0))) {
                identifiersBST.add(token);
		// if it does start with a letter, it's an identifier
                System.out.println("Identifier: " + token);
            }
        }
    }

    private void setBalancedBST(BinaryNode<String> node) {
        if (node != null) {
            // traverses the tree and balances each node
            setBalancedBST(node.getLeftChild());
            setBalancedBST(node.getRightChild());
            balance(node);
        }
    }

    private void balance(BinaryNode<String> node) {
	// height of left tree minus height of right, for determining balancing
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeftChild()) < 0) {
                node.setLeftChild(leftRotate(node.getLeftChild()));
            }
            node = rightRotate(node);
	    // if left tree taller than right, rotates right
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRightChild()) > 0) {
                node.setRightChild(rightRotate(node.getRightChild()));
            }
            node = leftRotate(node);
	    // if right tree taller than left, rotates left
        }

        // updates height after balance
        updateHeight(node);
    }

    private int getBalanceFactor(BinaryNode<String> node) {
        // gets balance factor of node, for rotation
        return (node == null) ? 0 : node.getLeftChildHeight() - node.getRightChildHeight();
    }

    private BinaryNode<String> rightRotate(BinaryNode<String> y) {
        // rotates right when left tree is too tall
        return x;
    }

    private BinaryNode<String> leftRotate(BinaryNode<String> x) {
        // rotates left when right tree is too tall
        return y;
    }

    // updates the height of the node
    private void updateHeight(BinaryNode<String> node) {
        if (node != null) {
            node.setHeight(Math.max(node.getLeftChildHeight(), node.getRightChildHeight()) + 1);
        }
    }
}
