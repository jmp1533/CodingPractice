package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon10819 {
    static int N, result = 0;
    static int[] arr, A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            int total = 0;

            for (int i = 0; i < N-1; i++) {
                total += Math.abs(arr[i] - arr[i + 1]);
            }

            result = Math.max(result, total);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[cnt] = A[i];

            dfs(cnt + 1);

            visited[i] = false;
        }
    }
}