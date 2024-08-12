package tdd;

import java.io.OptionalDataException;
import java.util.Arrays;

public class addSecond {
    public int[] getArr(int[] arr) {

        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
           array[i] = arr[0] + arr[1];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + arr[arr.length - 1];

        }
        return array;
    }


//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//        addSecond addSecond = new addSecond();
//        String arrays = Arrays.toString(addSecond.getArr(arr));
//
//        System.out.println(arrays);
//
//    }
}

