package arrayList;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList implements MyList {

    private Object[] array;

    private int size;

    public ArrayList() {
        int defaultSize = 10;
        array = new Object[defaultSize];
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    private Object[] grow() {
        int newCapacity = (array.length * 3 / 2);
        return array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public void add(Object element) {
        if (element == null) throw new IllegalArgumentException("You try to put NULL element");
        if (size == array.length) {
            array = grow();
        }
        array[size++] = element;
    }

    @Override
    public void add(int index, Object element) {
        if (size == array.length) array = grow();
        if (index > size || index < 0) throw new IllegalArgumentException("There is no index like " + index);
        if (element == null) throw new IllegalArgumentException("You try to put NULL element");

        int j = 0;
        Object[] rightArray = Arrays.copyOfRange(array, index, size);
        array[index] = element;
        size++;
        for (int i = index + 1; i < size; i++) {
            array[i] = rightArray[j++];
        }

    }

    @Override
    public void addAll(MyList list) {
        if (list == null) throw new IllegalArgumentException("You try to put list of NULL");
        int j = 0;
        while (!(array.length >= list.size() + size)) array = grow();
        for (int i = size; i < list.size() + size; i++) {
            array[i] = list.get(j++);
        }
        size += list.size();

    }

    private void shiftLeft(int index) {
        int j = 0;
        Object[] rightArray = Arrays.copyOfRange(array, index + 1, size);
        array[index] = null;
        size--;
        for (int i = index; i < size; i++) {
            array[i] = rightArray[j++];
        }
    }

    @Override
    public boolean delete(int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("There is no index like " + index);
        for (Object item : array) {
            if (indexOf(item) == index) {
                shiftLeft(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object element) {
        if (element == null) throw new IllegalArgumentException("You try to delete NULL element");
        for (Object item : array) {
            if (item == element) {
                shiftLeft(indexOf(item));
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Object item : array) item = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("There is no index like " + index);
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) throw new IllegalArgumentException("You try to get index from NULL element");
        for (int i = 0; i < size; i++) {
            if (array[i] == element) return i;
        }
        return -1;
    }


    @Override
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex != size;
            }

            @Override
            public Object next() {
                return array[nextIndex++];
            }
        };
    }

    public String print() {
        Object[] content = Arrays.copyOfRange(array, 0, size);
        return Arrays.toString(content);
    }
}
