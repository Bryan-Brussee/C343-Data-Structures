import java.util.Scanner;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class lab08 {

    public int addToDictionary() throws IOException {
	URL url = new URL("https://homes.soic.indiana.edu/classes/summer2016/csci/c343-mitja/2016/labs/lab08.txt");
	Scanner in = new Scanner(url.openStream());
	int count = 0;
	HashMap m = new HashMap(400);
	while (in.hasNextLine()) {
	    String line = in.nextLine();
	    String[] words = line.split("\\s");
	    count++;
	    for (String word : words) {m.put(word, count);}
	    //System.out.println(word + " " + count);
	    //in.next();
	}
	in.close();
	System.out.println(m.entrySet());
	return count;
    }


    public static void main(String[] args) throws IOException {
	lab08 test = new lab08();
	test.addToDictionary();
	

    }

}
