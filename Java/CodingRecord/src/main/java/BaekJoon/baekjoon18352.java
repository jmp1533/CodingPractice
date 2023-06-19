package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon18352 {
    static int N, M, K, X;
    static int visited[];
    static ArrayList<Integer>[] graph;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        result = new ArrayList<>();

        for (int i = 0; i <= N; i++){
            visited[i] = -1;
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
        }

        bfs(X);

        for (int i = 0; i <= N; i++){
            if(visited[i] == K){
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else{
            Collections.sort(result);

            for (int temp : result){
                System.out.println(temp);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int destination : graph[now]){
                if (visited[destination]==-1){
                    visited[destination] = visited[now] + 1;
                    queue.add(destination);
                }
            }
        }
    }
}