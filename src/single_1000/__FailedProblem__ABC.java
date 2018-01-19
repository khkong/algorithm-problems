package single_1000;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 문제풀이 보류
 *
 * 풀이 방식.
 * 너비 우선 방식으로 풀어봤는데, 문자열 길이가 길어질 수록 3^n으로 데이터가 증가함.
 * 기본 문제는 풀리지만, K가 50이상 넘어갈 경우, 혹은 닶이 없을 경우("") 시간초과 발생.
 *
 * 깊이 우선 탐색도 마찬가지일 것으로 판단됨.
 * DP 관련 문제를 연습하고 풀어보면 풀릴것으로 판단됨.
 */

public class __FailedProblem__ABC {

    private final char[] ABC_ARR = {'A', 'B', 'C'};
    private final int ABC_ARR_SIZE = 3;
    private HashMap<String, Integer> mMap;

    public String createString(int N, int K) {
        String answer;
        ArrayList<String> startList = new ArrayList<String>();
        ArrayList<Integer> startPoint = new ArrayList<Integer>();
        startList.add("A");
        startList.add("B");
        startList.add("C");
        startPoint.add(0);
        startPoint.add(0);
        startPoint.add(0);
        answer = breadthFirstSearch(startList, startPoint, 2, N, K);

        int len = answer.length();
        if (len == 0)
            return "";

        int addLen = N - len;
        for (int i = 0; i < addLen; i++) {
            answer = 'C' + answer;
        }

        return answer;
    }

    public String breadthFirstSearch(ArrayList<String> survList, ArrayList<Integer> survPoint, int depth, int N, int K) {
        if (depth > N)
            return "";

        ArrayList<String> resultList = new ArrayList<String>();
        ArrayList<Integer> resultPoint = new ArrayList<Integer>();
        int size = survList.size();
        System.out.println("reulst size "+survList.size()+", "+survPoint.size());
        for (int i = 0; i < size; i++) {
            String candiStr = survList.get(i);
            int prevPoint = survPoint.get(i);
            for (int j = 0; j < ABC_ARR_SIZE; j++) {
                int point = calcPoint(candiStr, ABC_ARR[j], prevPoint);
                if (point == K) {
                    String tmp = candiStr + ABC_ARR[j];
                    return tmp;
                } else if (point < K) {
                    String tmp = candiStr + ABC_ARR[j];
                    resultList.add(tmp);
                    resultPoint.add(point);
                }
            }
        }

        return breadthFirstSearch(resultList, resultPoint, depth + 1, N, K);
    }

    public int calcPoint(String str, char ch, int prevPoint) {
        int point = prevPoint;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char tmp = str.charAt(i);
            if (tmp < ch)
                point++;
        }
        return point;
    }

    public static void main(String[] args) {
        __FailedProblem__ABC abc = new __FailedProblem__ABC();
        long time = System.currentTimeMillis();
        System.out.println(abc.createString(50, 70));
        long endTime = System.currentTimeMillis();
        System.out.println("spend time : " + (endTime - time));
    }
}
