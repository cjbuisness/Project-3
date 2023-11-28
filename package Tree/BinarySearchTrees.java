package Tree;

public class BinarySearchTrees<T extends Comparable<? super T>> implements SearchTreeInterface<T> {
    private BinaryNode<T> root;

    public BinarySearchTrees() {
	// creates empty BST
        root = null;
    }

    public BinarySearchTrees(T rootData) {
	// creates BST with rootData
        root = new BinaryNode<>(rootData);
    }

    @Override
    public boolean isEmpty() {
	// empt check
        return root == null;
    }

    @Override
    public int getHeight() {
	// return height
        return (root == null) ? 0 : root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
	// return # of nodes
        return (root == null) ? 0 : root.getNumberOfNodes();
    }

    @Override
    public void clear() {
	// emtpies tree
        root = null;
    }

    @Override
    public boolean contains(T entry) {
        return getEntry(entry) != null;
    }

    @Override
    public T getEntry(T entry) {
        return findEntry(root, entry);
    }

    @Override
    public T add(T newEntry) {
        root = addEntry(root, newEntry);
        root = rebalanceTree(root);
        return newEntry;
    }

    @Override
    public T remove(T entry) {
        root = removeEntry(root, entry);
        root = rebalanceTree(root);
        return entry;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private T findEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return null;
        }

        int comparison = compareEntries(entry, rootNode.getData());

        if (comparison == 0) {
            return rootNode.getData();
        } else if (comparison < 0) {
            return findEntry(rootNode.getLeftChild(), entry);
        } else {
            return findEntry(rootNode.getRightChild(), entry);
        }
    }

    private BinaryNode<T> addEntry(BinaryNode<T> rootNode, T newEntry) {
        if (rootNode == null) {
            return new BinaryNode<>(newEntry);
        }

        int comparison = compareEntries(newEntry, rootNode.getData());

        if (comparison < 0) {
            rootNode.setLeftChild(addEntry(rootNode.getLeftChild(), newEntry));
        } else if (comparison > 0) {
            rootNode.setRightChild(addEntry(rootNode.getRightChild(), newEntry));
        }

        return rootNode;
    }

    private T removeEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return null;
        }

        int comparison = compareEntries(entry, rootNode.getData());

        if (comparison == 0) {
            T data = rootNode.getData();
            rootNode = removeFromRoot(rootNode);
            return data;
        } else if (comparison < 0) {
            rootNode.setLeftChild(removeEntry(rootNode.getLeftChild(), entry));
        } else {
            rootNode.setRightChild(removeEntry(rootNode.getRightChild(), entry));
        }

        return rootNode.getData();
    }

    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
        if (rootNode.isLeaf()) {
            return null;
        } else if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
            T replacement = findLargest(rootNode.getLeftChild());
            rootNode.setData(replacement);
            rootNode.setLeftChild(removeLargest(rootNode.getLeftChild()));
        } else {
            return (rootNode.hasLeftChild()) ? rootNode.getLeftChild() : rootNode.getRightChild();
        }

        return rootNode;
    }

    private T findLargest(BinaryNode<T> rootNode) {
        return (rootNode.hasRightChild()) ? findLargest(rootNode.getRightChild()) : rootNode.getData();
    }

    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
        return (rootNode.hasRightChild()) ? removeLargest(rootNode.getRightChild()) : rootNode.getLeftChild();
    }

    private void inOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.println(node.getData());
            inOrderTraversal(node.getRightChild());
        }
    }

    private int compareEntries(T entry1, T entry2) {
        return entry1.toString().compareToIgnoreCase(entry2.toString());
    }

    private BinaryNode<T> rebalanceTree(BinaryNode<T> rootNode) {
        return rootNode;
    }
}
