package BaekJoon;
/*

*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1405 {
    static int[] X = { 0, 0, 1, -1 };
    static int[] Y = { 1, -1, 0, 0 };
    static boolean[][] visited = new boolean[30][30];
    static double[] probability;
    static int N;
    static double result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        probability = new double[4];

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            probability[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;

        dfs(15, 15, visited, 0, 1.0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, boolean[][] visited, int cnt, double percentage) {
        if (cnt == N) {
            result += percentage;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + X[i];
            int dy = y + Y[i];

            if (dx <= 0 || dx >= 30 || dy <= 0 || dy >= 30) {
                continue;
            }

            if (!visited[dx][dy]) {
                visited[dx][dy] = true;

                dfs(dx, dy, visited, cnt + 1, percentage * probability[i]);

                visited[dx][dy] = false;
            }
        }
    }
}