package BaekJoon;
/*
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.
둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            // 초기화
            int X = Integer.parseInt(st.nextToken());
            origin[i] = X;
            sorted[i] = X;
        }

        // sorted 정렬
        Arrays.sort(sorted);

        // 정렬 된 배열 순회하면서 map 넣기
        int idx = 0;
        for(int i = 0; i < sorted.length; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], idx);
                idx++;
            }
        }

        for(int i = 0; i < origin.length; i++) {
            int index = map.get(origin[i]); // 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(index).append(' ');
        }

        System.out.println(sb);
    }
}