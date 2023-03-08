package BaekJoon;
/*
문제
오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.

깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.

입력
첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.

다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다.
(1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.

출력
첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다.
시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon24479 {
    static ArrayList<Integer>[] nodes;
    static boolean visited[];
    static int[] result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];
        result = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for (int i = 1; i < nodes.length; i++) {
            Collections.sort(nodes[i]);
        }

        result[R] = 1;
        visited[R] = true;
        count = 2;
        bfs(R);

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int root) {
        for (int num : nodes[root]) {
            if (!visited[num]) {
                result[num] = count++;
                visited[num] = true;

                bfs(num);
            }
        }
    }
}