package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> graph[] = new LinkedList[N];
        int cost[] = new int[N];
        int degree[] = new int[N];
        int answer[] = new int[N];
        boolean visited[] = new boolean[N];
        int result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());
            graph[i] = new LinkedList<>();
            degree[i] = Integer.parseInt(st.nextToken());

            if(degree[i] == 0) {
                visited[i] = true;
                q.add(i);
                answer[i] = cost[i];
                continue;
            }

            for(int j = 0; j < degree[i]; j++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                graph[x].add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : graph[now]) {
                answer[next] = Math.max(answer[next], answer[now]+cost[next]);
                degree[next]--;

                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for(int i=0; i<N; i++) {
            result = Math.max(result, answer[i]);
        }

        System.out.println(result);
    }
}