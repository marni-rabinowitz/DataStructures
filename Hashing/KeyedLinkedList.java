
/**
 * This KeyedLinkedList object represents a Keyed List ADT implemented as
 * a LinkedList.
 * 
 * @author 
 * @version 
 */
public class KeyedLinkedList<K,V> implements KeyedLinkedListInterface<K,V>
{
    private KeyNode first;
    private int size;

    // a private inner class that represents a doubly 
    // linked-list node that contains both a key and a value
    private class KeyNode
    {
        K key;
        V value;
        KeyNode previous;
        KeyNode next;

        public KeyNode(K key, V value, KeyNode previous, KeyNode next)
        {
            this.key = key;
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
    public KeyedLinkedList(){
        first = null;
        size = 0;
    }
    // returns the logical size of this list
    public int size()
    {
        return size;      // complete this method
    }

    // if key found, update value and return false (nothing added), 
    // otherwise grow list and return true
    public boolean put(K key, V value)
    {
        KeyNode current = first;
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return false;
            }
            current = current.next;
        }
        KeyNode temp = new KeyNode(key, value, null, first); //adding to the front
        first = temp;
        size++;
        return true;
    }

    // search for key, return associated value
    // if key not found, return null
    public V get(K key)
    {
        KeyNode current = first;
        while(current != null){// for(int i = 0; i < size; i++){
            if(current.key.equals(key))
                return current.value;
            current = current.next; 
        }
        return null;    // complete this method
    }

    // removes the element at the specified key location in this list
    // return true if remove was successful, false if key not found
    public boolean remove(K key)
    {
        KeyNode current = first;
        KeyNode previous = first;
        // if(first.key.equals(key)){
        //     first = first.next;
        //     size--;
        //     return true;
        // }
        if(first != null && first.key.equals(key)){
            first = first.next;
            size--;
            return true;
        }
        while(current != null){
            if(current.key.equals(key)){
                previous.next = current.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;   // complete this method
    }
}
