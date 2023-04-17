package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> graph[] = new ArrayList[N + 1];
        int dp[] = new int [N+1];

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[x].add(y);
        }

        for(int x = 1 ; x <= N ; x++) {
            for(int y : graph[x]){
                dp[x] = Math.max(dp[x], dp[y]+1);
            }

            System.out.print(dp[x] + " ");
        }
    }
}