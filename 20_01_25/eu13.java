
import java.io.*;
import java.math.BigInteger;

public class eu13 {


    public static void main(String[] args) {


        BigInteger sum =  BigInteger.ZERO;

        try (BufferedReader reader = new BufferedReader(new FileReader("20_01_25/eu13.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    
                    BigInteger bigNumber = new BigInteger(line.trim());
                    sum = sum.add(bigNumber);
                
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);

        String sumstr = sum.toString();

        System.out.println(sumstr.substring(0,10));

        
    }

}
