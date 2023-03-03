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

public class baekjoon11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        HanoiMove(N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void HanoiMove(int N, int A, int B, int C) {
        if (N == 1) {
            sb.append(A + " " + C + "\n");
            return;
        }

        HanoiMove(N - 1, A, C, B);
        sb.append(A + " " + C + "\n");
        HanoiMove(N - 1, B, A, C);
    }
}