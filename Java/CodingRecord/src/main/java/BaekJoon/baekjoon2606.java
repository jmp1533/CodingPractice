package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2606 {
    static int N, M;
    static int[][] graph;
    static int[] Visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Visited = new int[N + 1];
        graph = new int[N + 1][N + 1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(1);

        System.out.println(result - 1);
    }

    public static void dfs(int index) {
        if (Visited[index] == 1) {
            return;
        }

        Visited[index] = 1;
        result++;

        for (int i = 1; i < N+1; i++) {
            if (Visited[i] == 0 && graph[index][i] == 1) {
                dfs(i);
            }
        }
    }
}