package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon9084 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T, N, M;
        int[] dp, coins;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            dp = new int[M + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int m = coin; m <= M; m++) {
                    dp[m] += dp[m - coin];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb.toString());
    }
}