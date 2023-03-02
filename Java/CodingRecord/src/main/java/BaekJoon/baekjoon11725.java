package BaekJoon;
/*
문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11725 {
    static int N;
    static int parent[];
    static boolean visited[];
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]+"\n"));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for(int i = 0; i < tree[start].size(); i++) {
            int temp = tree[start].get(i);

            if(visited[temp] == false) {
                parent[temp] = start;
                dfs(temp);
            }
        }
    }
}