package single_250;

public class AB {
    public String createString(int n, int k) {
        StringBuffer sb = new StringBuffer();
        int selectCount = 0;
        int sum = 0;
        for (int i = n - 1; i > -1; i--) {
            if (sum + i - selectCount == k) {
                if (sum + i - selectCount < sum) {
                    return "";
                }
                sb.append('A');
                sum -= selectCount;
                selectCount++;
                for (int j = i; j > 0; j--) {
                    sb.append('B');
                }
                break;
            } else if (sum + i - selectCount < k) {
                if (sum + i - selectCount < sum) {
                    return "";
                }
                sb.append('A');
                sum += i - selectCount;
                selectCount++;
            } else {
                sb.append('B');
            }
        }

        if (selectCount == 0 || selectCount == n)
            return "";
        return sb.toString();
    }
    public static void main(String[] args) {
        AB ab = new AB();
        long time = System.currentTimeMillis();
        System.out.println(ab.createString(50, 100));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
    }
}



