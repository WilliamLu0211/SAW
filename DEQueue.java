/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */

public class DEQueue<T> implements Deque<T> {

    private DLLNode<T> _head, _tail;
    private int _size;
    
    public DEQueue() {
	_size = 0;
    }

    /* first */
    public void addFirst(E x) {
	if ( isEmpty() ) {
	    _head = new DLLNode(x, null, null);
	    _tail = _head;
	} else {
	    _head.setPrev( new DLLNode(x, null, _head) );
	    _head = _head.getPrev();
	}
	_size ++;
    }
    
    public boolean offerFirst(E x) {
	
    }

    // throw exception if empty
    public E removeFirst() {
	E rtnVal;
	if ( isEmpty() )
	    throw NoSuchElementException;
	else {
	    rtnVal = _head.getCargo();
	    if ( _size == 1 )
	}
    }
    
    public E pollFirst(); // return null if empty
    
    public E getFirst(); // throw exception if empty
    
    public E peekFirst(); // return null if empty
    
    public E removeFirstOccurrence(Object x);
    /* first */
    
    /* last */
    public void addLast(E x);
    
    public boolean offerLast(E x);
    
    public E removeLast(); // throw exception if empty
    
    public E pollLast(); // return null if empty
    
    public E getLast(); // throw exception if empty
    
    public E peekLast(); // return null if empty
    /* last */
    
    /* general */
    public boolean isEmpty();
    
    public boolean contains(Object x);
    
    public Iterator<E> iterator();
    
    public Iterator<E> 	descendingIterator();
    
    public int size();
    /* general */
    
}
