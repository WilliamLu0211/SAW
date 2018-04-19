/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */

public class DEQueue<T> implements Deque<T> {

    private DLLNode<T> _head, _tail;
    private int _size;
    
    public DEQueue() {
	_head = _tail = null;
	_size = 0;
    }

    /* first */
    public void addFirst(E x) {
	if ( isEmpty() ) {
	    _head = _tail = new DLLNode(x, null, null);
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
	if ( isEmpty() )
	    throw NoSuchElementException;
	else {
	    E rtnVal = _head.getCargo();
	    if ( _size == 1 )
		_head = _tail = null;
	    else {
		_head = _head.getNext();
		_head.setPrev(null);
	    }
	    size--;
	    return rtnVal;
	}
    }


    // return null if empty
    public E pollFirst() {
	if ( isEmpty() )
	    return null;
	else {
	    removeFirst(); // modularity!!!
	}
    } 

    // throw exception if empty
    public E getFirst() {
	if ( isEmpty() )
	    throw NoSuchElementException;
	else {
	    return _head.getCargo(); 
	}
    }

    // return null if empty
    public E peekFirst() {
	if ( isEmpty() )
	    throw NoSuchElementException;
	else {
	    getFirst();
	}
    } 
    
    public boolean removeFirstOccurrence(Object x) {
	DLLNode tmp = _head;
	while ( _tmp.getNext() ) {
	    return _tmp.getCargo().equals(x);
	}
	return false;
    }
    /* first */
    
    /* last */
    public void addLast(E x) {
	if ( isEmpty() ) {
	    _tail = _head = new DLLNode(x, null, null);
	} else {
	    _tail.setNext( new DLLNode(_tail, null, x) );
	    _tail = _tail.getNext();
	}
	_size ++;
    }
    
    public boolean offerLast(E x) {
	
    }
    
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
