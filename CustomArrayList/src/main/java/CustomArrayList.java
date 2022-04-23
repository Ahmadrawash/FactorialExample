import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged.
 *
 * //@param <e>
 */

//implements Iterator interface (from the following link)
    // https://gist.github.com/jnwhiteh/68d095c630dfcaddffd1
public class CustomArrayList<E> implements CustomListInterface<E>, Iterator<E> {
    private Object[] array;
    private int size;
    private int maxSize;
    Log log2;
    int currIndex = 0;

    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public CustomArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
        log2 = new Log("log.txt");
        log2.writeToLog("Constructor: new array has been created");
    }

    /**
     * Sized constructor, creates an empty object with maxSize size
     * @param size the initial size of the underlying array
     */
    public CustomArrayList(int size) {
        maxSize = size;
        if (size <= 0) {
            System.out.println("Exception: size parameter is 0");
            return;
        }
        this.size = 0;
        array = new Object[size];
         log2 = new Log("log.txt");
        log2.writeToLog("Constructor: new array has been created");
    }

    /**
     * Element list constructor, takes in variable number of objects and creates an underlying
     * array large enough to fit them.
     * @param e
     */
    public CustomArrayList(E ...e) {
        maxSize = size = e.length;
        array = new Object[size];

        log2 = new Log("log.txt");


        for (int i = 0; i < e.length; ++i) {
            array[i] = e[i];
        }
        //you forgot to increment the size of the array
        log2.writeToLog("Constructor: new array has been created");
    }


    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     * @param o object to be added
     */
    //@Override
    public void add(Object o) {
        //Implement this method
        // NOTE: if size >= maxSize we need to grow array
        if (size >= maxSize) {
            growArray();
            log2.writeToLog("Array has grown to max size " + maxSize);
        }
        array[size++] = o;
        log2.writeToLog(o + " Element has been added successfully at the end of the arrayList");

    }

    /**  I wrote this before finding out that you provided the method GrowArray.
    //grow the array to fit the new element. it grows the array by double the previous maximum size
    //steps:
    //  create a new array
    //  copies  all elements from old array to new array
    //  set the array to refer to newArray

    public void Grow()
    {
        int newSize = size *2;
        Object[] NewArray = new Object[newSize];
        for(int i = 0 ; i < size ;i++)
            NewArray[i] = array[i];
        maxSize = NewArray.length;
        array = NewArray;
        log2.writeToLog("Array has grown to max size " + maxSize);
    }

    /**
     * Adds object at specified index, advancing the size of the underlying array. This will
     * overwrite an existing element, rather than shift them
     * @param index index location where object will be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException
     */

    //@Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        //Implement this method
        if (index >= maxSize)
        {
            throw new IndexOutOfBoundsException();
        }
        array[index] = e;
        size++;
        log2.writeToLog(e + " Element has been added  at index " + index + " successfully");
    }

    /**
     * gets the object located at supplied index
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        //Implement this method
        if (index > maxSize || index < 0)
        {
            log2.writeToLog("Index out of Bound Exception when attempting to read element at index " + index);
            throw new IndexOutOfBoundsException("Index out of Bound Exception when attempting to read element at index " + index);
            //return null;
        }
        else
            return (E)array[index];
    }

    /**
     * Emptys the underlying array by setting it's private reference to null and allowing
     * the old array to be garbage collected.
     */
    @Override
    public void  clear() {
        //Implement this method
        array = null;
        size = 0;
        log2.writeToLog("array has been cleared");
    }

    /**
     * Check if object o is found within underlying array, using Object.equals() method
     * @param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public int contains(Object o) {
        //Implement this method
        for (int i = 0 ;i < size; i ++)
            if (array[i].equals(o)) return i;
        return -1;
    }

    /**
     * Removes object at specified index from underlying array, setting to null.
     * @param index index of object to remove from array
     */
    @Override
    public void remove(int index) {
        //Implement this method
        if (index < 0 || index >= size)
        {
            log2.writeToLog("Exception: Index out of bound when attempted to remove element. attempted index is " + index);
            return;
        }
        /** I thought (before reading your comments) that the elements to be re-arranged when removing an element.
        for(int i = index ; i < size-1; i++)
        {
            array[i] = array[i+1];
            System.out.println("printed: " + array[i]);
        }
        */
        array[index] = null;
        log2.writeToLog("Element at index " + index + " has been successfully removed");
    }

    /**
     * returns size of array. This is the one greater than the index of the most advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {
        //Implement this method
        return size;
    }


    /**
     * Doubles the size of the underlying array by creating a new array and copying the
     * contents of the previous array into it.
     */
    private void growArray(){
        //System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        //set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        //copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }

    //I have added this method to print all elements of the array
    public void PrintArray()
    {
        for(int i = 0 ; i < size; i ++)
            if (array[i] != null)
                System.out.println(" element " + i + " is " + array[i]  + ", ");
            else
                System.out.println(" element " + i + " is null");
    }

    //method needed to implement the Iterator Interface
    //implements the IIterator to support using forEach with CustomArrayList class
    //https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
    @Override
    public boolean hasNext() {
        if (array.length != 0 && currIndex < array.length )
            return true;
        else return false;
    }

    public void Reset(){
        currIndex = 0;
    }

    @Override
    public E next()
    {
        try
        {
            if (hasNext()) return (E)array[currIndex++];
            else {
                throw new Exception("No more additional elements");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public Iterator<E> iterator() {
        return new CustomArrayList<E>();
    }



}