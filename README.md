# Team SAW 
## *S*hayan Chowdhury, *A*ddison Huang, *W*illiam Lu
### APCS2 pd2
#
### Our Deque
We decided on a doubly-linked list as our underlying container, due to it providing the most efficient structure to carry out the tasks of the Deque interface. All of our methods except `removeFirstOccurence` and `removeLastOccurence`, as of now operate in constant runtime since a linked list allows us to add or remove elements to the beginning without shifting over the cargo of each element afterwards (which would run in linear runtime). 


### Our Initial Todo
- [x] Write Deque interface
- [x] Write class that uses Deque interface
- [x] Test
- [x] Achieve perfection


### Our In-Depth Process
1) Write Deque methods that deal with first
    - [x] void addFirst(E x) 
    - [x] E removeFirst()
    - [x] E pollFirst()
    - [x] E getFirst()
    - [x] E peekFirst()
    - [x] E removeFirstOccurrence(Object x)
    - [x] E removeLastOccurrence(Object x)
2) Write Deque methods that deal with last
    - [x] void addLast(E x);
    - [x] E removeLast(); // throw exception if empty
    - [x] E pollLast(); // return null if empty
    - [x] E getLast(); // throw exception if empty
    - [x] E peekLast(); // return null if empty
3) Write other Deque methods (if deemed necessary)
    - [x] boolean contains(Object x)
    - [x] Iterator iterator()
    - [x] Iterator descendingIterator()
    - [x] String toString()
3) Test each method after implementation
4) Run entire class
5) Make necessary changes
6) Make a driver file to test implementation
7) **Repeat** until perfection is achieved


Bet nobody [**SAW**](http://m.memegen.com/b07s25.jpg) this coming..
