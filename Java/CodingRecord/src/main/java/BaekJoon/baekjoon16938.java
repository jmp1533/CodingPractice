package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon16938 {
    static int N, L, R, X = 0;
    static int result = 0;
    static int[] level;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        level = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(level);

        dfs(0, Integer.MAX_VALUE, 0, 0);

        System.out.println(result);
    }

    public static void dfs(int index, int min, int max, int sum) {
        if (index >= 2 && L <= sum && sum <= R && max - min >= X) {
            result++;
        }

        for (int i = index; i < N; i++) {
            dfs(i + 1, Math.min(min, level[i]), Math.max(max, level[i]), sum + level[i]);
        }
    }
}