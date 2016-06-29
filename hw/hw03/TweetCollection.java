//C343 / Summer 2016
//Homework 03
//Bryan Brussee
//bbrussee


import java.util.LinkedList;
import java.util.Scanner;      // for Scanner
import java.io.IOException;    // for IOException
import java.net.URL;           // for URL
public class TweetCollection {

    public static LinkedList<Tweet> storage;

    public void constructor(){
	storage = new LinkedList<Tweet>();
    }

    public void addTweet(Tweet addtw){
	storage.add(addtw);
    }

    public void storeTweets() throws IOException{
	
        URL url = new URL("http://homes.soic.indiana.edu/classes/summer2016/csci/c343-mitja/2016/homework/tweet-data-June29.txt");
    	Scanner s = new Scanner(url.openStream());
	
    	while (s.hasNext()){
    	    Tweet newTweet = new Tweet();
	    newTweet.constructor(s.next(), s.nextLine());
	    storage.add(newTweet);
    	}
	s.close();
    }

    public void printCollection() {
	int i = 0;
	while (i < storage.size()) {
	Tweet grabfirst = storage.get(i);
	grabfirst.printTweet();
	i++;
	}
    }

    public Tweet  grabTweet(int i) {
	storage.get(i).printTweet();
	return storage.get(i);

    }


    public static void main(String args[]) throws IOException{

	TweetCollection testcollection = new TweetCollection();
	testcollection.constructor();
	testcollection.storeTweets();
	testcollection.printCollection();
	testcollection.grabTweet(0);
	testcollection.grabTweet(5);

	// Tweet test = new Tweet();
	// test.constructor("bbrussee", "hi");
	// testcollection.addTweet(test);
	// Tweet test2 = new Tweet();
	// //test2.constructor("bbrussee2", "hi2");
	// //testcollection.addTweet(test2);
	// testcollection.printCollection();
	// // test.printTweet();
	// // Tweet second = new Tweet();
	// // second.newTweet("This is my second tweet", "bbrussee");
	// // second.printTweet();
	// // TweetCollection newcol = new TweetCollection();
	// // newcol.addTweet()


	// String input = "NoSQLDigest RT @markcote873: RT mshogan775 Why Big Data Is a Big Deal - How Big Data Will Make Solar Energy a Reality https://t.co/ZVqh0j0gZq #bigdata";
	// Scanner s = new Scanner(input);
	// test.constructor(s.next(), s.nextLine());
	// test.printTweet();
	// // System.out.println("Author: " +  s.next());
	// // System.out.println("Tweet: " + s.nextLine());
	// // test.newTweet(s.next(), s.next)
	
    }
}
