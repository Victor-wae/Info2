import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object[] list;
    private int size;


    public MyArrayList(int initSize) {
        if (initSize <= 0) throw new IndexOutOfBoundsException("Size must be greater than 0");
        size = 0;
        list = new Object[initSize];
    }


    /*
     * Checks if 'list' needs to be resized then add the element at the end
     * of the list.
     */
    public void enqueue(Item item) {
        if (size >= list.length) {
            Object[] newList = new Object[size * 2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            this.list = newList;
        }
        list[size + 1] = item;
        size++;
    }


    /*
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list. You dont need to
     * resize when removing an element.
     */
    public Item remove(int index) {
        // YOUR CODE HERE
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Item data = (Item) list[index];
        for (int i = index; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[size - 1] = null;
        size--;
        return data;

    }


    public int size() {
        return this.size;
    }


    public Object[] getList() {
        return this.list;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        int initialSize = MyArrayList.this.size;
        int currentIndex = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (size != initialSize) throw new ConcurrentModificationException();
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (Item) list[currentIndex++];
        }
    }

}