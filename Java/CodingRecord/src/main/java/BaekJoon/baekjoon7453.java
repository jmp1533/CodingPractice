package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];
        int preSum[][] = new int[2][N * N];
        long result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                preSum[0][idx] = arr[i][0] + arr[j][1];
                preSum[1][idx] = arr[i][2] + arr[j][3];

                idx++;
            }
        }

        Arrays.sort(preSum[0]);
        Arrays.sort(preSum[1]);

        int first = 0;
        int second = preSum[0].length - 1;
        int end = N * N;
        while (first < end && 0 <= second) {
            int sum =  preSum[0][first] + preSum[1][second];
            int fCnt =1;
            int sCnt = 1;
            if (sum == 0) {
                while (first <= end - 2 && preSum[0][first] == preSum[0][first + 1]) {
                    fCnt++;
                    first++;
                }

                while (0 < second && preSum[1][second] == preSum[1][second - 1]) {
                    sCnt++;
                    second--;
                }

                result += (long) fCnt * sCnt;
            }

            if (sum < 0) {
                first++;
            } else{
                second--;
            }
        }

        System.out.println(result);
    }
}