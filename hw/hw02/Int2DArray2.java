import java.util.Arrays;

public class Int2DArray2 implements Int2DArray{

    public static int[][] array = new int[7][10];
    

    public void insert(int value, int x, int y){
	array[x][y] = value;
    }

    public void print(){
	System.out.println(Arrays.deepToString(array));
    }
    
    public boolean isThereRoom(){
	boolean answer = false;
	for (int i = 0; i < array.length; i++){
	    for (int j = 0; j < array[0].length; j++){
		if (array[i][j] == 0)
		    answer = true;
	    }
	}
	System.out.println(answer);
	return answer;
    }

    public int howMany(){
	int counter = 0;
	for (int i = 0; i < array[0].length; i++){
	    for (int j = 0; j < array.length; j++){
		counter++;
	    }
	}
	System.out.println("This array has room for " + counter + " items.");
	return counter;
    }
    
    public void remove(int x, int y){
	array[x][y] = 0;
    }

    public static void main(String args[]){
	Int2DArray2 test = new Int2DArray2();
	//System.out.println(Arrays.deepToString(array));
	test.howMany();
	test.insert(5,0,0);
	test.isThereRoom();
	test.print();
	//System.out.println(Arrays.deepToString(array));

    }

}
