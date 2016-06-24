public interface Int2DArray {


    //inserts a value into the given location
    public void insert(int value, int x, int y);
   
    //prints the 2D array
    public void print();

    //returns TRUE if any elements in the array are null
    public boolean isThereRoom();

    //returns the number of lists within the main list 
    public int howMany();

    //inserts NULL at the specified value
    public void remove(int x, int y);
}


    
