import java.util.Random;


public class DNADist{

   static String makeDNA(){
       String DNAalphabet = "ATCG";
       String s = "";
       Random rnd = new Random();
       
       for (int i = 0; i < 20; i ++) {
            int t = rnd.nextInt(4);
        String randomletter = DNAalphabet.substring(t, t+1);
       s = s.concat(randomletter);
       }
       return s;
   }
    public static void main(String args[]){
	String dna1 = DNADist.makeDNA();
	String dna2 = DNADist.makeDNA();
	int count = 0;
	for (int i = 0; i < 20; i++)
	    if (dna1.charAt(count) == dna2.charAt(count))
			count++;
	System.out.println(dna1);
	System.out.println(dna2);
	System.out.println(count);
    }
}
