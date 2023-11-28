package Tree;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
	// creates empty binary tree
        root = null;
    }

    @Override
    public void setTree(T rootData) {
	// sets root of created tree
        root = new BinaryNode<>(rootData);
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
	// sets roots of subtrees
        root = new BinaryNode<>(rootData,
                leftTree != null ? leftTree.getRootNode() : null,
                rightTree != null ? rightTree.getRootNode() : null);
    }

    @Override
    public BinaryNode<T> getRootNode() {
	// returns the root node
        return root;
    }

    @Override
    public boolean isEmpty() {
	// checks if root node is empty
        return root == null;
    }

    @Override
    public int getHeight() {
	// returns height of tree
        return root == null ? 0 : root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
	// returns number of nodes in the tree
        return root == null ? 0 : root.getNumberOfNodes();
    }

    @Override
    public void clear() {
	// sets root to null; clears tree
        root = null;
    }
}
