import java.util.Arrays;
public class CountingSort {


    public int[] countingSort(int[] myarray) {
	//phase zero
	//calculates k
	int count = myarray[0];
	for (int i = 1; i < myarray.length; i++) {
	    if (myarray[i] > count) {count = myarray[i];}
	}
	int k = count + 1;
	//phase one
	int[] B = new int[k];
	for (int i = 0; i < myarray.length; i++) {
	    int atmp = myarray[i];
	    B[atmp] += 1;
	}
	//phase two
	int totalSoFar = 0;
	for (int i = 1; i < k; i++) {
	    int tmpCount = B[i];
	    B[i] = totalSoFar;
	    totalSoFar += tmpCount;
	}
	//phase three
	int[] C = new int[myarray.length];
	for (int i = 0; i < myarray.length; i++) {
	    int atmp = myarray[i];
	    int outindex = B[atmp];
	    C[outindex] = myarray[i];
	    B[atmp] += 1;
	}
	System.out.println("The max value is: " + count);
	System.out.println(Arrays.toString(myarray));
	System.out.println(Arrays.toString(C));
	return C;
    }

    public static void main(String args[]) {
	CountingSort test = new CountingSort();
	int[] testarray = new int[5];
	testarray[0] = 43 ;
	testarray[1] = 27;
	testarray[2] = 5;
	testarray[3] = 207;
	testarray[4] = 3;
	
	test.countingSort(testarray);
    }

}
