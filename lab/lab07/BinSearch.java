import java.util.*;
import java.io.*;
public class BinSearch <E extends Comparable<?super E>>{

    public int  BinSearch(E[] A, E K) {
    	int l = -1;
    	int r = A.length;
    	while (l + 1 != r) {
    	    int i = (l+r)/2;
    	    int compare = K.compareTo(A[i]);
    	    if (A[i].compareTo(K) == 0) { return i; }
    	    else if (A[i].compareTo(K) > 0) { r = i; }
    	    else { l = i; }
    	}
    	System.out.println("The value you searched for is not in the array.");
    	return A.length;
    }
   

    public static void main (String[] args) {
        BinSearch<Integer> a = new BinSearch<Integer>();
        Integer[] i = {1,2,3,4,5};
	int q = 4;
	int result = 0;
	result = a.BinSearch(i, q); 
	System.out.println(q + " is at index " + result);
	BinSearch<String> b = new BinSearch<String>();
	String[] test2 = {"hey", "heyo", "howdy", "wassup"};
	String search2 = "howdy";
	System.out.println(search2 + " is at index " + b.BinSearch(test2, search2));
	BinSearch<Float> c = new BinSearch<Float>();
	Float[] test3 = {1.0f, 3.2f, 4.7f, 5.2f, 7.0f};
	Float search3 = 4.7f;
	System.out.println(test3);
	System.out.println(search3 + " is at index " + c.BinSearch(test3, search3));

    }

}
