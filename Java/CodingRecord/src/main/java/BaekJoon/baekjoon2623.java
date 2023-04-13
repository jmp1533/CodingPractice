package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int j = 1; j < cnt; j++) {
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                degree[y]++;
                x = y;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            answer.add(x);

            for (int y : graph[x]) {
                degree[y]--;

                if (degree[y] == 0){
                    queue.add(y);
                }
            }
        }

        if(answer.size() != N) {
            System.out.println(0);
        }
        else {
            for (int x : answer) {
                sb.append(x).append('\n');
            }

            System.out.println(sb.toString());
        }
    }
}