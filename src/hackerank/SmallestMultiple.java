package hackerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallestMultiple {
    //1~N의 수열이 있을때 모든 수들의 치소공배수 구하기
    // N 이 40이하이므로, 0~40까지의 소수를 구하고
    // 소인수 분해로 최소공배수를 한다.

    public static int primeNum[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    public static long div(long a, int b) {
        if (a == 0 || b == 0)
            return 1;

        for (int i = 0; i < primeNum.length; i++) {
            int pn = primeNum[i];
            if (pn > a || pn > b)
                break;
            if (a % pn == 0 && b % pn == 0) {
                return pn * div(a / pn, b / pn);
            }
        }
        return a * b;
    }

    public static void smallestMultiple(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = div(result, i);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            smallestMultiple(n);
        }
    }
}
