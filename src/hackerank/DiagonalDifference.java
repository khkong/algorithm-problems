package hackerank;

import java.util.Scanner;

public class DiagonalDifference {

    static int diagonalDifference(int[][] a) {
        // Complete this function
        int len = a.length;
        int d1 = 0;
        int d2 = 0;
        for(int i =0 ; i < len ; i ++){
            d1 += a[i][i];
            d2 += a[len - (i+1)][i];
        }
        return Math.abs(d1-d2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
