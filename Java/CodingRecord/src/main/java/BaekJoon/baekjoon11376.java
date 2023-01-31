package BaekJoon;
/*
문제
강호네 회사에는 직원이 N명이 있고, 해야할 일이 M개가 있다.
직원은 1번부터 N번까지 번호가 매겨져 있고, 일은 1번부터 M번까지 번호가 매겨져 있다.
각 직원은 최대 두 개의 일을 할 수 있고, 각각의 일을 담당하는 사람은 1명이어야 한다.
각각의 직원이 할 수 있는 일의 목록이 주어졌을 때, M개의 일 중에서 최대 몇 개를 할 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 직원의 수 N과 일의 개수 M이 주어진다. (1 ≤ N, M ≤ 1,000)
둘째 줄부터 N개의 줄의 i번째 줄에는 i번 직원이 할 수 있는 일의 개수와 할 수 있는 일의 번호가 주어진다.

출력
첫째 줄에 강호네 회사에서 할 수 있는 일의 개수를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11376 {
    private static int N, M;
    private static int[] work;
    private static int[][] possible;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int size = N * 2;
        visited = new boolean[M];
        work = new int[M];
        possible = new int[size + 1][];

        for (int i = 1; i <= size; i += 2) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());

            possible[i] = new int[index];
            possible[i + 1] = new int[index];

            for (int j = 0; j < index; j++) {
                possible[i][j] = Integer.parseInt(st.nextToken()) - 1;
                possible[i + 1][j] = possible[i][j];
            }
        }

        int result = 0;
        for (int i = 1; i <= size; i++) {
            Arrays.fill(visited, false);

            if (dfs(i)) result++;
        }

        System.out.println(result);
        br.close();
    }

    public static boolean dfs(int num) {
        for (int i = 0; i < possible[num].length; i++) {
            if (visited[possible[num][i]]) continue;

            visited[possible[num][i]] = true;

            if (work[possible[num][i]] == 0 || dfs(work[possible[num][i]])) {
                work[possible[num][i]] = num;
                return true;
            }
        }
        return false;
    }
}