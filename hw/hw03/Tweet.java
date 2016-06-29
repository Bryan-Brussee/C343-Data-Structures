public class Tweet {

    public String content;

    public String author;



    public void constructor(String freshauthor, String freshcontent) {
	
	content = freshcontent;

	author = freshauthor;


    }

    public void printTweet() {

	System.out.println("author: " + author + " " +  "\ncontent: " + content + "\n\n");
    }

    public static void main(String args[]) {
	Tweet test = new Tweet();
	test.constructor("Bryan Brussee", "Howdy");
	test.printTweet();
	Tweet second = new Tweet();
	second.constructor("bbrussee", "2");
	test.printTweet();
	second.printTweet();

    }
}
