package hackerank;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FromParagraphsToSentences {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named __FailedProblem__ProjectEuler197. */

        String regex = "(\".*?\".*?[\\!\\?\\.])|(.*?[\\!\\?\\.])";
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();
        //
        Pattern p = Pattern.compile(regex);
        Matcher m;
        while ((m = p.matcher(input)).find()) {
            String str;
            if (m.group(0) != null) {
                str = m.group(0);
            } else {
                str = m.group(1);
            }
            System.out.println(str);
            input = input.substring(str.length(), input.length()).trim();
        }
        scan.close();
    }
}
