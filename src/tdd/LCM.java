package tdd;
import java.util.Arrays;
public class LCM {

    public static void main(String[] args) {

        int[] multiples = {4, 6, 9};

        for(int i = 2; i < multiples.length; i++) {
           if(multiples[i] % i == 0) {
               System.out.println(multiples[i]);
           }
        }


    }


}
