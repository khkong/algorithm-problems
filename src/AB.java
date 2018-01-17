

/*You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
    The string has exactly N characters, each of which is either 'A' or 'B'.
    The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.*/
public class AB {
    public static String createString(int n, int k) {
        StringBuffer sb = new StringBuffer();
        int selectCount = 0;
        int sum = 0;
        for (int i = n - 1; i > -1; i--) {
            if (sum + i -selectCount== k) {
                if(sum + i - selectCount < sum){
                    return "";
                }
                sb.append('A');
                sum -= selectCount;
                selectCount++;
                for(int j = i; j > 0; j--){
                    sb.append('B');
                }
                break;
            } else if (sum + i -selectCount < k) {
                if(sum + i - selectCount < sum){
                    return "";
                }
                sb.append('A');
                sum += i - selectCount;
                selectCount++;
            } else {
                sb.append('B');
            }
        }

        if (selectCount == 0||selectCount == n)
            return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        AB ab = new AB();
        long time = System.currentTimeMillis();
        System.out.println(AB.createString(50, 100));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }
}

