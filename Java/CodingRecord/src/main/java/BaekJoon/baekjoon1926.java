package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1926 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] coordinateX = {-1,1,0,0};
    static int[] coordinateY = {0,0,-1,1};
    static int result, max = 0;

    static class Picture{
        int x;
        int y;

        Picture(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == false && graph[i][j] == 1) {
                    visited[i][j] = true;
                    Picture picture = new Picture(i, j);

                    bfs(picture);

                    result++;
                }
            }
        }

        System.out.println(result);
        System.out.println(max);
    }

    private static void bfs(Picture picture) {
        Queue<Picture> queue = new LinkedList<>();
        queue.add(picture);
        int area = 1;

        while (!queue.isEmpty()){
            Picture now = queue.poll();

            for(int dir=0; dir<4; dir++){
                int x = now.x + coordinateX[dir];
                int y = now.y + coordinateY[dir];

                if(x <0 || x >= N || y<0 || y >= M) continue;
                if(visited[x][y] == true || graph[x][y] == 0) continue;

                visited[x][y] = true;
                queue.add(new Picture(x, y));
                area++;
            }
        }

        max = Math.max(area, max);
    }
}