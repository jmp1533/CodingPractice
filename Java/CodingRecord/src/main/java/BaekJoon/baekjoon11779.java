package BaekJoon;

import java.io.*;
import java.util.*;

public class baekjoon11779 {
    static int N, M;
    static List<Integer>[] city;
    static int[] minCost;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    static StringBuilder sb;
    static class Node implements Comparable<Node> {
        public int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        city = new List[N + 1];
        minCost = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            city[i] = new ArrayList<>();
            minCost[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startCity].add(new Node(endCity, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        System.out.println(sb);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        city[start].add(start);
        minCost[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(minCost[cur.end] < cur.cost) continue;
            if(!visited[cur.end]) visited[cur.end] = true;

            for(int i = 0; i < graph[cur.end].size(); i++) {
                Node node = graph[cur.end].get(i);
                int min = cur.cost + node.cost;

                if(!visited[node.end] && min <= minCost[node.end]) {
                    minCost[node.end] = min;
                    city[node.end].clear();

                    for(int j = 0; j < city[cur.end].size(); j++) {
                        city[node.end].add(city[cur.end].get(j));
                    }

                    city[node.end].add(node.end);
                    queue.add(new Node(node.end, minCost[node.end]));
                }
            }
        }

        sb.append(minCost[end]).append("\n");
        sb.append(city[end].size()).append("\n");

        for(int i = 0; i<city[end].size(); i++) {
            sb.append(city[end].get(i) + " ");
        }
    }
}