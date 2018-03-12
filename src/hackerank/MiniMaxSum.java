package hackerank;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {
    static void miniMaxSum(int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        int len = arr.length;
        long min = 0;
        long max = 0;
        min = (long)arr[0]+(long)arr[1]+(long)arr[2]+(long)arr[3];
        max = (long)arr[len-1]+(long)arr[len-2]+(long)arr[len-3]+(long)arr[len-4];

        System.out.println(min+" "+max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}
