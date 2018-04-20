/*  Team SAW - Shayan Chowdhury, Addison Huang, William Lu
    APCS2 pd2
    L02 -- All Hands on Deque!
    2018-4-20 F */
import java.util.Iterator;
public class Driver {
    public static void main(String[] args) {
	QQKachoo josh= new QQKachoo<Integer>();
	System.out.println("adding ints [0,9) to josh at the front.....");
	for (int i = 0; i < 10; i++) { 
	    josh.addFirst(i);
	    System.out.println(josh.peekFirst());
	    //should print 0, 1, 2 ... 9
	}
	System.out.println("adding ints [10,19) to josh at the back.....");
	for (int i = 10; i < 20; i++) {
	    josh.addLast(i);
	    System.out.println(josh.peekLast());
	    //should print 10, 11, 12 ... 19
	}
	System.out.println("removing the first five elements of josh.....");
	for (int i = 0; i < 5; i++) {
	    System.out.println(josh.removeFirst());
	    //should print 9, 8, 7, 6, 5
	}
	System.out.println("removing the first occurence of 4.....");
	josh.removeFirstOccurrence(4);
	System.out.println("printing the first element of josh.....");
	System.out.println(josh.peekFirst()); //should be 3
	System.out.println("removing the first occurence of 19.....");
	josh.removeFirstOccurrence(19);
	System.out.println("printing the last element of josh.....");
	System.out.println(josh.peekLast()); //should be 18
	System.out.println("adding int 18 to the front of josh.....");
	josh.addFirst(18);
	System.out.println("removing the last occurence of 18.....");
	josh.removeLastOccurrence(18);
	System.out.println("printing the last element of josh.....");
	System.out.println(josh.peekLast()); //should be 17
	System.out.println("printing the size of josh.....");
	System.out.println(josh.size());//should be 13
	System.out.println("testing iterator.....");
	Iterator<Integer> ints = josh.iterator();
	System.out.println("printing out the elements of josh.....");
	while (ints.hasNext()) {
	    System.out.print(ints.next() + ", ");
	    //should print 18, 3, 2, 1, 0, 10, 11, 12, 13, 14, 15, 16, 17
	    ints.remove();
	}
	
			       
    }
}
