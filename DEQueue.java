/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */

import java.util.NoSuchElementException;
import java.util.Iterator;
    
public class DEQueue<E> implements Deque<E> {

    //instance vars
    private DLLNode<E> _head, _tail;
    private int _size;

    //default constructor
    public DEQueue() {
        _head = _tail = null;
        _size = 0;
    }

    /* All methods that deal with first */
    /*--------------------
      void addFirst(E x)
      adds x to the front of the DEQueue
      increments size by 1
      --------------------*/
    public void addFirst(E x) {
        if ( isEmpty() ) { //special case if DEQueue is empty
            _head = _tail = new DLLNode<E>(x, null, null);
        } else {
            _head.setPrev( new DLLNode<E>(x, null, _head) );
            _head = _head.getPrev();
        }
        _size ++;
    }

    /*--------------------
      E removeFirst()
      throws a NoSuchElementException if the DEQueue is empty
      else removes the first item in the DEQueue 
      decrements size 
      returns the item that is removed
      --------------------*/
    public E removeFirst() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        E rtnVal = _head.getCargo();
        _head = _head.getNext();
        if ( _size == 1 ) //special case if there is only 1 item in the DEQueue
            _tail = _head;
        else _head.setPrev( null );
        _size--;
        return rtnVal;
    }

    /*--------------------
      E pollFirst()
      returns null if the DEQueue is empty
      else removes the first item in the DEQueue 
      decrements size 
      returns the item that is removed
      --------------------*/
    public E pollFirst() {
        if ( isEmpty() )
            return null;
        return removeFirst(); // modularity!!!
    } 

    /*--------------------
      E getFirst()
      throws a NoSuchElementException if the DEQueue is empty
      else returns the first item in the DEQueue
      --------------------*/
    public E getFirst() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        return _head.getCargo(); 
    }

    /*--------------------
      E peekFirst()
      returns null if the DEQueue is empty
      else returns the first item in the DEQueue
      --------------------*/
    public E peekFirst() {
        if ( isEmpty() )
            return null;
        return getFirst();
    }

    /*--------------------
      boolean removeFirstOccurence(Object x)
      removes the first occurence of x in the DEQueue
      returns true if it was successful, decrements size
      returns false if it was unsuccessful
      --------------------*/
    public boolean removeFirstOccurrence(Object x) {
        DLLNode temp = _head;
        while ( temp != null ) {
            if ( temp.getCargo().equals(x) ) {
                temp.getPrev().setNext( temp.getNext() );
                temp.getNext().setPrev( temp.getPrev() );
                _size --;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    /* All methods that deal with first */
    
    /* All methods that deal with last */
    /*--------------------
      void addLast(E x)
      adds x to the back of the DEQueue
      increments size by 1
      --------------------*/
    public void addLast(E x) {
        if ( isEmpty() ) {
            _tail = _head = new DLLNode<E>(x, null, null);
        } else {
            _tail.setNext( new DLLNode<E>(x, _tail, null) );
            _tail = _tail.getNext();
        }
        _size ++;
    }

    /*--------------------
      E removeLast()
      throws a NoSuchElementException if the DEQueue is empty
      else removes the last item in the DEQueue 
      decrements size 
      returns the item that is removed
      --------------------*/
    public E removeLast() {
        if ( isEmpty() ) //special case if the DEQueue is empty
            throw new NoSuchElementException();
        E rtnVal = _tail.getCargo();
        _tail = _tail.getPrev();
        if ( _size == 1 )
            _head = _tail;
        else _tail.setNext( null );
        _size--;
        return rtnVal;
    }

    /*--------------------
      E pollLast()
      returns null if the DEQueue is empty
      else removes the last item in the DEQueue 
      decrements size 
      returns the item that is removed
      --------------------*/
    public E pollLast() {
        if ( isEmpty() )
            return null;
        return removeLast();
    }

    /*--------------------
      E getLast()
      throws a NoSuchElementException if the DEQueue is empty
      else returns the last item in the DEQueue
      --------------------*/
    public E getLast() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        return _tail.getCargo();
    }

    /*--------------------
      E peekLast()
      returns null if the DEQueue is empty
      else returns the last item in the DEQueue
      --------------------*/
    public E peekLast() {
        if ( isEmpty() )
            return null;
        return getLast();
    }

    /*--------------------
      boolean removeLastOccurence(Object x)
      removes the last occurence of x in the DEQueue
      returns true if it was successful, decrements size
      returns false if it was unsuccessful
      --------------------*/
    public boolean removeLastOccurrence(Object x) {
	DLLNode temp = _tail;
        while ( temp != null ) {
            if ( temp.getCargo().equals(x) ) {
                temp.getPrev().setNext( temp.getNext() );
                temp.getNext().setPrev( temp.getPrev() );
                _size --;
                return true;
            }
            temp = temp.getPrev();
        }
        return false;
    }
    /* All methods that deal with last */
    
    /* general */
    /*--------------------
      boolean isEmpty()
      returns true if the size of the DEQueue is 0
      returns false otherwise
      --------------------*/
    public boolean isEmpty() { return _size == 0; }

    /*--------------------
      boolean contains(Object x)
      returns true if Object x is in the DEQueue
      returns false otherwise
      --------------------*/
    public boolean contains( Object x ) {
        DLLNode temp = _head;
        while ( temp != null ) {
            if ( temp.getCargo().equals(x) )
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    /*--------------------
      int size()
      accessor for size
      --------------------*/
    public int size() { return _size; }

    /* nested class MyIterator */
    private class MyIterator<E> implements Iterator<E> {
        
        private DLLNode<E> _temp;
        private boolean forward;
        private boolean _okToRemove;

	//default constructor 
        public MyIterator( int d ) {
            if ( d == 0 ) {
                _temp = new DLLNode( null, null, _head );
                forward = true;
            } else {
                _temp = new DLLNode( null, _tail, null );
                forward = false;
            }
            _okToRemove = false;
        }

	/*--------------------
	  boolean hasNext()
	  returns true if there is another item in the DEQueue
	  --------------------*/
        public boolean hasNext() {
            if (forward) return _temp.getNext() != null;
            else return _temp.getPrev() != null;
        }

	/*--------------------
	  E next()
	  throws a NoSuchElementException if there is no next item
	  else returns the next element, sets _okToRemove to true
	  --------------------*/
        public E next() {
            if (forward) {
                _temp = _temp.getNext();
                if ( _temp == null )
                    throw new NoSuchElementException();
            } else {
                _temp = _temp.getPrev();
                if ( _temp == null )
                    throw new NoSuchElementException();
            }
            _okToRemove = true;
            return _temp.getCargo();
        }

	/*--------------------
	  void remove()
	  throws IllegalStateException if _okToRemove is false
	  else removes the nextElement, sets _okToRemove to false, decrements size
	  --------------------*/
        public void remove() {
            if ( ! _okToRemove )
                throw new IllegalStateException("must call next() beforehand");
            if ( _head == _tail )
                _head = _tail = null;
            else  if ( _temp == _head ) {
                _head = _head.getNext();
                _head.setPrev( null );
            } else if ( _temp == _tail ) {
                _tail = _tail.getPrev();
                _tail.setNext( null );
            } else {
                _temp.getNext().setPrev( _temp.getPrev() );
                _temp.getPrev().setNext( _temp.getNext() );
            }
            _okToRemove = false;
            _size --;
        }
    }

    /*--------------------
      Iterator<E> iterator()
      returns an instance of MyIterator that iterates from left to right
      --------------------*/
    public Iterator<E> iterator() {
        return new MyIterator(0);
    }

    /*--------------------
      Iterator<E> descendingIterator()
      returns an instance of MyIterator that iterates from right to left
      --------------------*/
    public Iterator<E> 	descendingIterator() {
        return new MyIterator(1);
    } 
    /* general */
    
}
