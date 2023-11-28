package Tree;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {
    boolean contains(T entry);
    //checks if tree contains entry; returns true or false

    T getEntry(T entry);
    // returns entry from tree, or null

    T add(T newEntry);
    // adds new entry to tree, returns entry

    T remove(T entry);
    // removes entry from tree, returns removed entry, or null
} 
