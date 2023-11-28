package Tree;

public interface TreeInterface<T> {
    boolean isEmpty();
    // checks if tree is empty, returns true or false

    int getHeight();
    // returns height of the tree

    int getNumberOfNodes();
    // returns # of nodes in tree

    void clear();
    // clears all elements from tree
}
