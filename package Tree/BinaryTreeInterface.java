package Tree;

public interface BinaryTreeInterface<T> extends TreeInterface<T> {

    void setTree(T rootData);
	// sets tree with root data

    void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
	// sets the tree with specifc root data, left sub, and rght sub

    BinaryNode<T> getRootNode();
	// returns root node of binary tree
}
