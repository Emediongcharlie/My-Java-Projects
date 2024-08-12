package tdd;

import java.util.*;

public class RemoveDuplicate {

    public static int[] duplicate(int[] numbers) {
        int[] arr2 = new int[numbers.length];
        int i = 0;

        for (i = 0; i < numbers.length; i++) {
            if (numbers[i]!= arr2[i]) {
                arr2[i] = numbers[i];
            }
        }
        return arr2;
    }
    public static void main(String[] args) {
        int[] input = {1, 1, 2, 3, 3, 4};
        String result = Arrays.toString(RemoveDuplicate.duplicate(input));
        System.out.println(result);
    }
}