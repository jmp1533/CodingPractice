package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon7579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] run = new int[N];
        int[] memory = new int[N];
        int[] dp;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            run[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            sum += memory[i];
        }

        dp = new int[sum+1];
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= memory[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-memory[i]]+run[i]);
            }
        }

        for (int i = 0; i <= sum; i++) {
            if(dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}