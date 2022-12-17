package BaekJoon;
/*

*/

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon11660 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        String[] str = br.readLine().split(" ");
        int n = sto(str[0]);
        int m = sto(str[1]);

        int[][] table = new int[n+1][n+1];
        int[][] preSum = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            str = br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                table[i][j] = sto(str[j-1]);
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + table[i][j];
            }
        }

        for(int i=1; i<=m; i++) {
            str = br.readLine().split(" ");
            int x1 = sto(str[0]);
            int y1 = sto(str[1]);
            int x2 = sto(str[2]);
            int y2 = sto(str[3]);

            int result = preSum[x2][y2] - preSum[x1-1][y2]-preSum[x2][y1-1] + preSum[x1-1][y1-1];
            System.out.println(result);
        }

        bw.close();
    }

    private static int sto(String input) {
        return Integer.parseInt(input);
    }
}