package Tree;

public interface TreeIteratorInterface<T> {
    void setPreorder();
    // sets iterator to traverse tree in pre-order

    void setInorder();
    // sets terator to traverse in-order

    void setPostorder();
    // sets iterator to traverse in post-order

    void setLevelOrder();
    // sets iterator to traverse in level-order

    boolean hasNext();
    // checks if there are more elements in traversal

    T next();
    // gets next element in traversal
}
