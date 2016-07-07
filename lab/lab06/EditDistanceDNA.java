import java.lang.Math;
import java.io.*;

public class EditDistanceDNA {
    
    //int[][] d = new int[][];
    


    public void editDistance(String a, String b) {
	int m = a.length();
	int n = b.length();
	int[][] d = new int[m+1][n+1];
	for(int i = 0; i < m; i ++) d[i][0] = i;
	for(int j = 0; j < n; j ++) d[0][j] = j; 
	//fill the table:
	for(int i = 1; i < m; i ++)  {
	    for(int j = 1; j < n; j ++) {
		int c = 0;
		if(a.charAt(i) == b.charAt(j)){ c = 0; }
                else {c = 1;} 
                d[i][j] = Math.min(d[i-1][j] + 1, Math.min(d[i][j-1] + 1, d[i-1][j-1] + c));
		    }
	}
	System.out.println( d[m][n] );
    }
    
    
    public static void main(String[] argv) throws FileNotFoundException {
	
	//Scanner in = new Scanner (new FileReader(argv[0]));
	EditDistanceDNA test = new EditDistanceDNA();
	
	test.editDistance("AFASFD", "CAT");
	

	//in.close();
	
	
    }
}
