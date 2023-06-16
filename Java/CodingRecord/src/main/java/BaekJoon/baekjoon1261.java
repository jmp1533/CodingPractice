package BaekJoon;

import java.io.*;
import java.util.*;

public class baekjoon1261 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs(0,0);

        System.out.println(result);
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int minDestroy = Integer.MAX_VALUE;

        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int curX = node.x;
            int curY = node.y;

            if(curX == N-1 && curY == M-1) {
                minDestroy = Math.min(minDestroy, node.destroy);
                return minDestroy;
            }

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny]) {
                    if(graph[nx][ny] == 0) {
                        queue.add(new Node(nx, ny, node.destroy));
                    }
                    else if(graph[nx][ny] == 1) {
                        queue.add(new Node(nx, ny, node.destroy + 1));
                    }

                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int destroy;

        Node(int x, int y, int destroy){
            this.x = x;
            this.y = y;
            this.destroy = destroy;
        }

        @Override
        public int compareTo(Node other) {
            return this.destroy - other.destroy;
        }
    }
}