package hackerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPalindrome {
    public static boolean check(int a) {
        String num = String.valueOf(a);
        int len = num.length();
        for (int i = 0; i < len >> 1; i++) {
            if (num.charAt(i) != num.charAt(len - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void calc(int n) {
        int best = 0;
        int x = 0;
        int y = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int tmp = i * j;
                if (n > tmp) {
                    if (tmp > best) {
                        if (check(tmp)) {
                            best = tmp;
                            x = i;
                            y = j;
                        }
                    }
                }

            }
        }
        System.out.println(best);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            calc(n);
        }
    }
}
