package BaekJoon;
/*
문제
현민이는 트리 모양의 길 위에서 오토바이를 타고 전단지를 돌리려고 한다.
현민이의 목표는 케니소프트에서 출발하여 모든 노드에 전단지를 돌리고, 다시 케니소프트로 돌아오는 것이다.
현민이는 힘이 좋기 때문에 현재 노드에서 거리가
$D$ 이하인 모든 노드에 전단지를 돌릴 수 있다.

날씨가 매우 덥기 때문에, 현민이는 최소한만 이동해서 목표를 달성하고 싶다! 현민이를 위해 현민이가 이동해야 하는 총 거리를 구해주자.

입력
첫번째 줄에는 노드의 개수 N( 1 <= N <= 100000)과 케니소프트의 위치 S(1 <= S <= N), 힘 D(0 <= D <= N)이 주어진다.

두 번째 줄부터
N번째 줄까지, 트리의 간선 정보를 의미하는 두 자연수 x,y가 공백으로 구분되어 주어진다.
이는 x번 노드와 y번 노드가 연결되어 있음을 의미한다. (1 <= x, y <= N, x != y)

주어지는 연결관계는 트리를 구성하며, 모든 간선의 길이는 1이다.

출력
현민이가 목표를 완수하기 위해 이동해야 하는 최소 거리를 출력하여라.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon19542 {
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int D;
    private static int move = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        visited[S] = true;
        dfs(S);

        System.out.println(Math.max(0, (move-1) * 2));
    }

    static int dfs(int cur) {
        int max = 0;

        for (int next : tree[cur]) {
            if (visited[next]) continue;

            visited[next] = true;
            max = Math.max(max, dfs(next));
        }

        if (max >= D) move++;

        return max+1;
    }
}