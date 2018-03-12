package hackerank;

import java.io.*;
import java.util.*;

public class __FailedProblem__ProjectEuler197 {
    public static double calc(double x, int b) {
        double indices = b - (x * x);
        return Math.pow(2, indices) * Math.pow(10, -9);
    }

    public static double prevCalc(double u, int b) {
        double r = u * Math.pow(10, 9);
        double log = Math.log(r);
        return b - log;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named __FailedProblem__ProjectEuler197. */
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int b = in.nextInt();

        double u = calc(x, b);
        for (int i = 0; i <= 12; i++) {
            u = calc(u, b);
        }
        System.out.println(u);
        double reulst = u*2;
        String num = String.format("%.9f", reulst);
        System.out.println(num);
    }
}