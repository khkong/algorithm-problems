package hackerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenFibonacciNumbers {
    public static void calc(long n) {
        long prevNum = 0;
        long num = 1;
        long sum = 0;

        long  tmp;
        while ((tmp = num + prevNum) < n) {
            if (tmp % 2 == 0)
                sum += (tmp);
            prevNum = num;
            num = tmp;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            calc(n);
        }
    }
}
