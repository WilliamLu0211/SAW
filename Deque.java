/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */

import java.util.Iterator;

public interface Deque<E> extends Iterable<E> {
    
    /* first */
    public void addFirst(E x);
    
    public E removeFirst(); // throw exception if empty
    
    public E pollFirst(); // return null if empty
    
    public E getFirst(); // throw exception if empty
    
    public E peekFirst(); // return null if empty
    
    public boolean removeFirstOccurrence(Object x);
    /* first */
    
    /* last */
    public void addLast(E x);
    
    public E removeLast(); // throw exception if empty
    
    public E pollLast(); // return null if empty
    
    public E getLast(); // throw exception if empty
    
    public E peekLast(); // return null if empty

     public boolean removeLastOccurrence(Object x);
    /* last */
    
    /* general */
    public boolean contains(Object x);
    
    public Iterator<E> iterator();
    
    public Iterator<E> 	descendingIterator();
    
    public int size();
    /* general */
    
}
