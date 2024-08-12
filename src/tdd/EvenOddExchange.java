package tdd;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddExchange {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] numbers = {4, 5, 8, 8, 8, 2, 9};
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] % 2 == 0) {
//                System.out.println("true");
//            }
//            if (numbers[i] % 2 != 0) {
//                System.out.println("false");
//            }
//        }
//    }


    public static String exchange(int[] numbers) {

        boolean [] result = new boolean[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result[i] = false;
            }
            else{
                result[i] = true;
            }

        }
        return Arrays.toString(result);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {4, 5, 8, 8, 8, 2, 9};
            System.out.print(EvenOddExchange.exchange(numbers));

    }
}






