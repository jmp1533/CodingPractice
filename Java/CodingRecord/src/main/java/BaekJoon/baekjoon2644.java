package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2644 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int result = -1;

    static class info{
        int index, count;

        public info(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(start, end, N);

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start, int end, int N) {
        Queue<info> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        visited[start] = true;
        q.add(new info(start, 0));

        while(!q.isEmpty()){
            info cur = q.poll();

            if(cur.index == end){
                result = cur.count;
                break;
            }

            for(int index : graph.get(cur.index)){
                if(!visited[index]){
                    visited[index] = true;
                    q.add(new info(index, cur.count+1));
                }
            }
        }
    }
}