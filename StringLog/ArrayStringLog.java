
/**
 * This ArrayStringLog object represents a StringLog ADT implemented as
 * a String array using the EnhancedStringLogInterface.
 * 
 * @author  
 * @version 
 */
public class ArrayStringLog implements EnhancedStringLogInterface
{
    // Instance variables
    private String[] log;
    private String name;
    private int size;

    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayStringLog(String name)
    {
        //size =4; 
        log = new String[4];
        //size = log.length -1;
        this.name = name;
        for(int i =0; i < log.length; i++)
        {
            if(log[i] != null)
            {
                size++;
            }
        }
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return size;
    }

    // Returns true if this list contains no elements.
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }

    // Returns true if this list is completely full.
    public boolean isFull()
    {
        if(size == log.length)
        {
            return true;
        }
        return false;
    }

    public void checkSize()
    {
        if(isFull() == true)
        {
            String[] temp = new String[size + size];
            for(int i =0; i < log.length; i++)
            {
                temp[i] = log[i];
            }
            log = temp;
        }
        //         if(size == (log.length/4))
        //         {
        //             String[] temp = new String[size/2];
        //             for(int i =0; i < temp.length; i++)
        //             {
        //                 temp[i] = log[i];
        // 
        //             }
        //             log = temp;
        //             size --;
        //         }
        ///return size;
    }
    // Appends the specified element to the end of this list.
    public void add(String element)
    {
        checkSize();
        log[size] = element;
        size++;
    }

    // Returns the element at the specified position in this list.
    public String get(int index)
    {
        return log[index];
    }

    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(String element)
    {
        for(int i = 0; i < size; i++)
        {
            if(log[i] == element)
            {
                return i;
            }
        }
        return -1;
    }

    // Returns true if this list contains the specified element.
    public boolean contains(String element)
    {
        for(int i = 0; i < size; i++)
        {
            if(log[i] == element)
            {
                return true;
            }
        }
        return false;
    }

    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }

    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public String set(int index, String element)
    {
        //log[index] = null;
        String x = log[index];
        log[index] = element;
        return x;
    }

    // Inserts the specified element at the specified position in this list.
    public void add(int index, String element)
    {
        checkSize();
        //og[index] = element;
        // String x = "";
        for(int i = log.length -1; i > index; i--)
        {
            log[i] = log[i-1]; 
        }
        log[index] = element;
        size++;
    }

    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public String remove(int index)
    {
        String a = log[index];
        for(int i = 0; i < log.length-1; i++)
        {
            if(i >= index)
            {
                log[i] = log [i+1];
            }
        }
        size--;
        return a;
   }

    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(String element)
    {
        for(int i = 0; i < size; i ++)
        {
            if(log[i] == element)
            {
                log[i] = null;
                size --;
            }
        }
        return false;
    }

    // Removes all of the elements from this list.
    public void clear()
    {
        for(int i = 0; i < log.length; i++)
        {
            log[i] = null;
            size--;
        }
    }
}
