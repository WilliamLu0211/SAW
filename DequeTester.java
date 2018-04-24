import java.util.Iterator;

public class DequeTester {
    
    public static void main(String[] args) {
	
	Deque will = new QQKachoo<Integer>();
	
	System.out.println("adding ints [0,9) to will at the front.....");
	for (int i = 0; i < 10; i++) { 
	    will.addFirst(i);
	    System.out.println(will.peekFirst());
	    //should print 0, 1, 2 ... 9
	}

	System.out.println( "will: " + will );
	
	System.out.println("adding ints [10,19) to will at the back.....");
	for (int i = 10; i < 20; i++) {
	    will.addLast(i);
	    System.out.println(will.peekLast());
	    //should print 10, 11, 12 ... 19
	}

	System.out.println( "will: " + will );
	
	System.out.println("removing the first five elements of will.....");
	for (int i = 0; i < 5; i++) {
	    System.out.println(will.removeFirst());
	    //should print 9, 8, 7, 6, 5
	}

	System.out.println( "will: " + will );
	
	System.out.println("removing the first occurence of 4.....");
	will.removeFirstOccurrence(4);
	System.out.println("printing the first element of will.....");
	System.out.println(will.peekFirst()); //should be 3
	System.out.println("removing the first occurence of 19.....");
	will.removeFirstOccurrence(19);
	System.out.println("printing the last element of will.....");
	System.out.println(will.peekLast()); //should be 18
	System.out.println("adding int 18 to the front of will.....");
	will.addFirst(18);
	System.out.println("removing the last occurence of 18.....");
	will.removeLastOccurrence(18);
	System.out.println("printing the last element of will.....");
	System.out.println(will.peekLast()); //should be 17
	System.out.println("printing the size of will.....");
	System.out.println(will.size());//should be 13
	System.out.println("testing iterator.....");

	for ( Object x : will )
	    System.out.println( x );
	
	Iterator<Integer> ints = will.iterator();
	System.out.println("printing out the elements of will.....");
	while (ints.hasNext()) {
	    System.out.print(ints.next() + ", ");
	    //should print 18, 3, 2, 1, 0, 10, 11, 12, 13, 14, 15, 16, 17
	    ints.remove();
	}

	System.out.println( "will: " + will );
				       
    }
}
