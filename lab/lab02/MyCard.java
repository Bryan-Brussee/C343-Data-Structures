import java.util.Arrays;
import java.util.Random;
public class MyCard implements Card{
    
   public  String[] deck = new String[52];

    public void initialize() {
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    String[] suit = {"C", "D", "H", "S"}; 
    //int decklength = rank.length * suit.length;
    // String[] deck = new String[52];
    int counter = 0;
    for (int i = 0; i < rank.length; i++) {
    	for (int j = 0; j < suit.length; j++) {
    	    deck[counter] = rank[i] + suit[j];
    	    counter++;
    	}    
    }
    System.out.println(Arrays.toString(deck));
}

    public String drawRandomCard(){
	Random rnd = new Random();
	int t = rnd.nextInt(52);
	String randomcard = deck[t];
	System.out.println(randomcard);
	return randomcard;
    }
    
    public static void main(String args[]){
	MyCard test = new MyCard();
	test.initialize();
	test.drawRandomCard();
	test.drawRandomCard();
	test.drawRandomCard();
	
    }
    
}
