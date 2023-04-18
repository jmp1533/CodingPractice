package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] in = new int[N + 1];
        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph[X][Y] = Integer.parseInt(st.nextToken());
            in[Y]++;
            visited[X] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                q.add(i);
                arr[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int now = (int) q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[now][i] != 0) {
                    arr[i] += arr[now] * graph[now][i];
                    in[i]--;

                    if (in[i] == 0){
                        q.add(i);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                System.out.print(i + " " + arr[i] + "\n");
        }
    }
}