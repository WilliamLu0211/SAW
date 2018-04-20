/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */

import java.util.NoSuchElementException;
import java.util.Iterator;
    
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

    // throw exception if empty
    public E removeFirst() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        E rtnVal = _head.getCargo();
        _head = _head.getNext();
        if ( _size == 1 )
            _tail = _head;
        else _head.setPrev( null );
        size--;
        return rtnVal;
    }


    // return null if empty
    public E pollFirst() {
        if ( isEmpty() )
            return null;
        return removeFirst(); // modularity!!!
    } 

    // throw exception if empty
    public E getFirst() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        return _head.getCargo(); 
    }

    // return null if empty
    public E peekFirst() {
        if ( isEmpty() )
            return null;
        return getFirst();
    }
    
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
    /* first */
    
    /* last */
    public void addLast(E x) {
        if ( isEmpty() ) {
            _tail = _head = new DLLNode(x, null, null);
        } else {
            _tail.setNext( new DLLNode(x, _tail, null) );
            _tail = _tail.getNext();
        }
        _size ++;
    }
    
    // throw exception if empty
    public E removeLast() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        E rtnVal = _tail.getCargo();
        _tail = _tail.getPrev();
        if ( _size == 1 )
            _head = _tail;
        else _tail.setNext( null );
        size--;
        return rtnVal;
    }
    
    // return null if empty
    public E pollLast() {
        if ( isEmpty() )
            return null;
        return removeLast();
    }
    
    // throws exception if empty
    public E getLast() {
        if ( isEmpty() )
            throw new NoSuchElementException();
        return _tail.getCargo();
    }
    
    // return null if empty
    public E peekLast() {
        if ( isEmpty() )
            return null;
        return getLast();
    }
    /* last */
    
    /* general */
    public boolean isEmpty() { return _size == 0; }
    
    public boolean contains( Object x ) {
        DLLNode temp = _head;
        while ( temp != null ) {
            if ( temp.getCargo().equals(x) )
                return true;
            temp = temp.getNext();
        }
        return false;
    }
    
    private class MyIterator implements Iterator<E> {
        
        private DLLNode<E> _temp;
        private boolean forward;
        private boolean _okToRemove;
        
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
        
        public boolean hasNext() {
            if (forward) return _temp.getNext() != null;
            else return _temp.getPrev() != null;
        }
        
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
        
        public void remove() {
            if ( ! _okToRemove )
                throw new IllegalStateException("must call next() beforehand");
            if ( _head == _tail )
                _head = _tail = null;
            else  if ( _temp = _head ) {
                _head = _head.getNext();
                _head.setPrev( null );
            } else if ( _temp = _tail ) {
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
    
    public Iterator<E> iterator() {
        return new MyIterator(0);
    }
    
    public Iterator<E> 	descendingIterator() {
        return new MyIterator(1);
    }
    
    public int size() { return _size; }
    /* general */
    
}
