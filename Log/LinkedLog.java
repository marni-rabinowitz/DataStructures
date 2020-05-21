
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.name = name;
        size = 0;
    }

    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }

    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        return false;
    }

    // returns true if this list is completely full
    public boolean isFull()
    {
        int a = 0;
        LLNode current = log;
        if(isEmpty() == false){
            while(current.getLink() != null){         
                a++;
                current = current.getLink();
            }
            if(a == size){
                return true;
            }
        }
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        LLNode n = new LLNode(element);
        if(log == null){
            log = n;
            size++;
        }
        else{
            LLNode current = log;
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setLink(n);
            size++;
        }
    }

    // returns the element at the specified position in this list
    public T get(int index)
    {
        LLNode current = log;
        for(int i = 0; i < index; i++){
            current = current.getLink();
        }
        return (T)current.getInfo();
    }

    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode current = log;
        int a = 0;
        while(current != null){
            if(current.getInfo() == (element))
                return a;
            a++;
            current = current.getLink();
        }
        return -1;
    }

    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        LLNode current = log;
        while(current != null){
            if(current.getInfo().equals(element))
                return true;
            current = current.getLink();
        }
        return false;
    }

    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;

        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
        return result;
    }

    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        LLNode current = log;
        for(int i = 0; i < index; i++){
            current = current.getLink();
        }
        T temp = (T)current.getInfo();
        current.setInfo(element);
        return temp;
    }

    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode newNode = new LLNode(element);
        LLNode current = log;
        size++;
        if(log == null){
            log = newNode;
        }
        if(index == 0){
            newNode.setLink(log);
        }
        for(int i = 1; i < index && current.getLink() != null; i++){
            current = current.getLink();
        }
        if(current.getLink() != null){
            newNode.setLink(current.getLink());
            current.setLink(newNode);
        }
        else{
            current.setLink(newNode);
        } 
    }

    // removes the element at the specified position in this list
    public T remove(int index)
    {
        LLNode current = log;
        LLNode previous = log;
        int a = 0;
        T c = null; 
        while(a != index){
            a++;
            if(current == null){
                return c;
            }
            else{
                previous = current;
                current = current.getLink();
            }
        }
        if(a==0){
            log = log.getLink();
        }
        if(a == index)
        {
            c = (T)current.getInfo();
            previous.setLink(current.getLink());
        }
        size--;
        return c;
    }

    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        if(log.getInfo() == element){
            log = log.getLink();
            size--;
            return true;
        }
        LLNode current = log;
        while(current.getLink() != null){
            if(current.getLink().getInfo() == element){
                current.setLink(current.getLink().getLink());
                size--;
                return true;
            }
            current = current.getLink();
        }
        return false;
    }

    // removes all of the elements from this list
    public void clear()
    {
        size = 0;
        log = null;
    }
}
