/**
 * This HashTable object represents a hash table ADT implemented as an array of doubly linked lists
 * 
 * @author  
 * @version 
 */
public class HashTable<K,V> implements HashTableInterface<K,V>
{
    private int size;
    private int capacity;
    private KeyedLinkedList<K,V> [] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity)
    {
        table = (KeyedLinkedList<K,V>[]) new KeyedLinkedList[capacity];
        size = 0;
        this.capacity = capacity;
        for(int i = 0; i < table.length; i++)
            table[i] = new KeyedLinkedList();
        // set the remaining instance variables
        // instantiate a new KeyedLinkedList<K,V> list in every element of table
    }

    // returns the number of keys in this hashtable
    public int size()
    {
        return size;
    }

    // clears this hashtable so that it contains no keys
    @SuppressWarnings("unchecked")
    public void clear()
    {
        table = (KeyedLinkedList<K,V>[]) new KeyedLinkedList[capacity];
        size = 0;
        for(int i = 0; i < table.length; i++)
            table[i] = new KeyedLinkedList();
        // it is essentially identical to the constructor
    }

    // returns the hashtable index for a given key
    public int hashIndex(K key)
    {
        // the line below insures a positive integer by eliminating the sign bit
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // if key found, update value and return false (nothing added), 
    // otherwise grow table and return true
    public boolean put(K key, V value)
    {
        KeyedLinkedList<K,V> list = table[hashIndex(key)];
        if(list.put(key, value)){
            size++;
            return true;
        }
        return false;   // complete this method
    }

    // search for key, return associated value
    // if key not found, return null
    public V get(K key)
    {
        for(int i = 0; i < capacity; i++){
            if(i == (hashIndex(key)))
            {
                return (V) table[i].get(key);
            }
        }
        return null;    // complete this method
    }

    // removes the element at the specified key location in this table
    // return true if remove was successful, false if key not found
    public boolean remove(K key)
    {
        KeyedLinkedList<K, V> list = table[hashIndex(key)];
        if(list.remove(key)){
            size--;
            return true;
        }
        return false;   // complete this method
    }
}
