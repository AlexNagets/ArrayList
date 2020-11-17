package arrayList;

public interface MyList extends Iterable<Object> {

    /**
     * Adds element to the end of collection
     */
    void add(Object element);

    /**
     * Adds element by specific index
     */
    void add(int index, Object element);

    /**
     * Adds all elements of MyList
     */
    void addAll(MyList c);

    /**
     * Delete element by specific index
     */
    boolean delete(int index);

    /**
     * Delete element from collection that equal to one in parameters
     */
    boolean delete(Object element);

    /**
     * purge all the elements
     */
    void clear();

    /**
     * return size of your list
     */
    int size();

    /**
     * Get element by specific index
     */
    Object get(int index);

    /**
     * Search for the element and return
     * it's index if found, -1 otherwise.
     */
    int indexOf(Object element);

    /**
     * True, if MyList contain such element, False otherwise
     */
    boolean contains(Object element);
}