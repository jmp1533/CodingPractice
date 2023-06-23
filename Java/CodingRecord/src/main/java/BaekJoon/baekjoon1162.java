package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1162 {
    static int N, M, K;
    static long MAX = Long.MAX_VALUE;
    static List<Node>[] graph;
    static long[][] distance;

    static class Node implements Comparable<Node> {
        int end, count;
        long time;

        public Node(int end, long time, int count) {
            this.end = end;
            this.time = time;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(time > o.time) return 1;
            else if(time < o.time) return -1;

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        distance = new long[N + 1][21];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            Arrays.fill(distance[i], MAX);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, time, 0));
            graph[end].add(new Node(start, time, 0));
        }

        Dijkstra(1);

        long result = MAX;
        for(int i = 0; i <= K; i++){
            result = Math.min(result, distance[N][i]);
        }

        System.out.println(result);
    }

    static void Dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        distance[start][0] = 0;
        queue.add(new Node(start, 0, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();

            int cur = node.end;
            long time = node.time;
            int count = node.count;

            if(distance[cur][count] < time) continue;

            for(Node e : graph[cur]){
                int next = e.end;
                long nextD = time + e.time;

                if(distance[next][count] > nextD){
                    distance[next][count] = nextD;

                    queue.add(new Node(next, nextD, count));
                }

                if(count < K && distance[next][count + 1] > time){
                    distance[next][count + 1] = time;

                    queue.add(new Node(next, time, count + 1));
                }
            }
        }
    }
}