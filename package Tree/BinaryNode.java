package Tree;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;
    private int height; 

    public BinaryNode(T data) {
	// creates a BinaryNode, with left and right initialized to null
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.height = 1;
    }

    public T getData() {
	// returns data of node
        return data;
    }

    public void setData(T data) {
	// sets data in node
        this.data = data;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
	// sets left child, updates height
        updateHeight();
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
        updateHeight();
    }

    public int getHeight() {
        return height;
    }

    public int getNumberOfNodes() {
        return (leftChild != null ? leftChild.getNumberOfNodes() : 0) +
               (rightChild != null ? rightChild.getNumberOfNodes() : 0) + 1;
	// returns # of nodes in subtree of current node
    }

    public boolean isLeaf() {
	// checks if node has children
        return leftChild == null && rightChild == null;
    }

    public boolean hasLeftChild() {
	// checks if node has left child
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public int getLeftChildHeight() {
        return (leftChild != null) ? leftChild.getHeight() : 0;
    }

    public int getRightChildHeight() {
        return (rightChild != null) ? rightChild.getHeight() : 0;
    }

    private void updateHeight() {
	// updates height based on height of children
        height = Math.max(getLeftChildHeight(), getRightChildHeight()) + 1;
    }
}
