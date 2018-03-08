package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Picnic {
    // Reference : https://algospot.com/judge/problem/read/PICNIC

    // 완전 탐색으로 풀이할 경우, 중복 문제가 발생할 수 있다.
    // 여기선 수가 가장 작은 것부터 찾아나가면서 중복을 피하는 방법을 사용함.
    // 전달 받은 짝 데이터를 정렬 한 후 문제를 풀이.
    // 짝수가 0부터 시작이다. 이 부분을 처리하지 못해 런타임 에러를 발생시키곤 했다.
    public int solution(int studentCnt, int pairCnt, ArrayList<int[]> pairList) {
        boolean check[] = new boolean[studentCnt];
        return recursion(pairList, 0, check);
    }

    private int recursion(final ArrayList<int[]> pairList, int depth, boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                break;
            }
            if (i == check.length - 1)
                return 1;
        }

        int sum = 0;
        int size = pairList.size();
        int prevX = 0;
        int prevY = 0;
        for (int i = depth; i < size; i++) {
            if (!check[pairList.get(i)[0]] && !check[pairList.get(i)[1]]) {
                if (prevX == pairList.get(i)[0] && prevY == pairList.get(i)[1])
                    continue;
                check[pairList.get(i)[0]] = true;
                check[pairList.get(i)[1]] = true;
                sum += recursion(pairList, i + 1, check);
                check[pairList.get(i)[0]] = false;
                check[pairList.get(i)[1]] = false;
                prevX = pairList.get(i)[0];
                prevY = pairList.get(i)[1];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        Comparator compare = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] arr1 = (int[]) o1;
                int[] arr2 = (int[]) o2;

                if (arr1[0] != arr2[0]) {
                    if (arr1[0] < arr2[0])
                        return -1;
                    else
                        return 1;
                } else {
                    if (arr1[1] < arr2[1])
                        return -1;
                    else
                        return 1;
                }
            }
        };

        Picnic picnic = new Picnic();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = Integer.parseInt(input);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            ArrayList<int[]> list = new ArrayList<int[]>();
            int studentCnt = 0;
            int pairCnt = 0;
            input = br.readLine();
            String token[] = input.split(" ");
            studentCnt = Integer.parseInt(token[0]);
            pairCnt = Integer.parseInt(token[1]);
            input = br.readLine();
            if(pairCnt > 0) {
                token = input.split(" ");
                int len = token.length;
                for (int j = 0; j < len; j += 2) {
                    int x = Integer.parseInt(token[j]);
                    int y = Integer.parseInt(token[j + 1]);
                    int pair[] = {x, y};
                    list.add(pair);
                }
            }
            Collections.sort(list, compare);
            result.add(picnic.solution(studentCnt, pairCnt, list));
        }

        for (int i = 0; i < count; i++) {
            System.out.println(result.get(i));
        }

    }
}
