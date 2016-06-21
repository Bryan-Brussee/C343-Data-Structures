import java.util.Random;


public class RandomDNA{

   public static void main(String args[]){
       String DNAalphabet = "ATCG";
       String s = "";
       Random rnd = new Random();
       
       for (int i = 0; i < 20; i ++) {
            int t = rnd.nextInt(4);
        String randomletter = DNAalphabet.substring(t, t+1);
       s = s.concat(randomletter);
       }
       System.out.println(s);
   }
}
