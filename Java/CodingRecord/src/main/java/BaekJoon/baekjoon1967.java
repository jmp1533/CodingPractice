package BaekJoon;
/*
문제
트리(tree)는 사이클이 없는 무방향 그래프이다. 트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다.
트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다.
이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.

이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다.
정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.

입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하는 프로그램을 작성하시오.
아래와 같은 트리가 주어진다면 트리의 지름은 45가 된다.

트리의 노드는 1부터 n까지 번호가 매겨져 있다.

입력
파일의 첫 번째 줄은 노드의 개수 n(1 ≤ n ≤ 10,000)이다. 둘째 줄부터 n-1개의 줄에 각 간선에 대한 정보가 들어온다.
간선에 대한 정보는 세 개의 정수로 이루어져 있다.
첫 번째 정수는 간선이 연결하는 두 노드 중 부모 노드의 번호를 나타내고, 두 번째 정수는 자식 노드를, 세 번째 정수는 간선의 가중치를 나타낸다.
간선에 대한 정보는 부모 노드의 번호가 작은 것이 먼저 입력되고, 부모 노드의 번호가 같으면 자식 노드의 번호가 작은 것이 먼저 입력된다.
루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.

출력
첫째 줄에 트리의 지름을 출력한다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1967 {
    public static int N;
    public static ArrayList<Node> list[];
    public static boolean visited[];
    public static int result = 0;

    public static class Node{
        int weight;
        int end;

        public Node(int end, int weight) {
            this.weight = weight;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        //초기화
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }

        //입력
        for(int i = 1; i <= N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, value));
            list[end].add(new Node(start, value));
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;

            dfs(i,0);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int sum) {
        if(N == 1) return;

        result = Math.max(sum, result);

        for(int i=0; i<list[start].size(); i++) {
            int end = list[start].get(i).end;

            if(visited[end]) continue;

            visited[end] = true;
            dfs(end, list[start].get(i).weight + sum);
            visited[end] = false;
        }
    }
}