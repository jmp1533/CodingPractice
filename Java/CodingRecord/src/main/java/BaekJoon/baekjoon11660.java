package BaekJoon;
/*
N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.
예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.

1	2	3	4
2	3	4	5
3	4	5	6
4	5	6	7
여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

입력
첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.
(1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)

출력
총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
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