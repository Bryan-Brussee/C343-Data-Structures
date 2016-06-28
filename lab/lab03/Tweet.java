public class Tweet {

    public static String content;

    public static String author;



    public void newTweet(String freshcontent, String freshauthor) {
	
	content = freshcontent;

	author = freshauthor;


    }

    public void printTweet() {

	System.out.println(content + " @" + author);
    }

    public static void main(String args[]) {
	Tweet test = new Tweet();
	test.newTweet("Hello World!", "Bryan Brussee");
	test.printTweet();
	Tweet second = new Tweet();
	second.newTweet("This is my second tweet", "bbrussee");
	second.printTweet();

    }
}
