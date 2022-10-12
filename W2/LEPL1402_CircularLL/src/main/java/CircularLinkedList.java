class ListNode<Item> {

    private Item item;
    private ListNode<Item> next;

    public ListNode(Item item){
        this.item = item;
        this.next = null;
    }

    public ListNode(Item item, ListNode<Item> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Return the item of the node
     *
     * @return The item contained in the node
     */
    public Item getItem() {
        return item;
    }

    /**
     * Get the next node in the list
     *
     * @return the next node in the list
     */
    public ListNode<Item> getNext() {
        return this.next;
    }

    /**
     * Set the followers of this node in the list
     *
     * @param next The node to put after this one
     */
    public void setNext(ListNode<Item> next) {
        this.next = next;
    }
}

public class CircularLinkedList<Item> {

    private int size;
    private ListNode<Item> first;
    private ListNode<Item> last;

    public CircularLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Add an element to the list
     *
     * @param item The element to add at the end of the list
     */
    public void enqueue(Item item) {
        ListNode<Item> newI= new ListNode<Item>(item);
        if (size == 0){
            first = newI;
            last = newI;
        }else {
            last.setNext(newI);
            last = newI;
            last.setNext(first);
        }
        size += 1;
    }

    /**
     * Remove an element of the list
     *
     * @param index The index of the element to remove
     * @throws IndexOutOfBoundsException if the index is
     *         less than 0 or greater to the size
     *         of the list
     */
    public Item remove(int index) {
        if (size == 0 || index > size || index < 0)throw new IndexOutOfBoundsException();
        else if (size == 1){
            Item item = first.getItem();
            first = last = null;
            size--;
            return item;
        }else if (index == 0){
            ListNode<Item> newF = first.getNext();
            ListNode<Item> prevF = first;
            last.setNext(newF);
            first = newF;
            size--;
            return prevF.getItem();
        }else {
            ListNode<Item> prev = first;
            for (int i = 0;i < index-1;i++){
                prev = prev.getNext();
            }
            ListNode<Item> toDel = prev.getNext();
            if (toDel == last){
                prev.setNext(first);
                last = prev;
                size--;
                return toDel.getItem();
            }
            prev.setNext(prev.getNext().getNext());
            size--;
            return toDel.getItem();
        }
    }

    /**
     * The size of the list
     *
     * @return The size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Is the list empty
     *
     * @return true if there is no element in the list
     *         and false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the first element of the list
     *
     * @return The first ListNode in the list
     */
    public ListNode<Item> getFirst() {
        return this.first;
    }

    /**
     * Get the last element of the list
     *
     * @return The last ListNode in the list
     */
    public ListNode<Item> getLast() {
        return this.last;
    }

}
