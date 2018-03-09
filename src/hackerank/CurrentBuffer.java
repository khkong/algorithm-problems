package hackerank;

import java.util.Scanner;

public class CurrentBuffer {
    static void insertionSort1(int n, int[] arr) {
        // Complete this function
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int val = arr[i];
            int idx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (val < arr[j]) {
                    arr[j + 1] = arr[j];
                    idx = j;
                }
            }

            if(idx >= 0) {
                arr[idx] = val;
            }

            for(int k =0 ; k < len ; k ++){
                System.out.print(arr[k]);
                if(k != len-1)
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int arr_i = 0; arr_i < n; arr_i++) {
//            arr[arr_i] = in.nextInt();
//        }
//        insertionSort1(n, arr);
//        in.close();
        int[] arr = {1, 4, 3, 5, 6, 2};
        insertionSort1(6, arr);
    }
}
