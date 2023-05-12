package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon16953 {
    private static long A;
    private static long B;
    private static long result = 1000;
    private static boolean status = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(A, 1);

        if(!status) result = -1;

        System.out.println(result);
    }

    public static void dfs(long number, int move) {
        if(number == B) {
            result = Math.min(result,  move);
            status = true;

            return;
        }

        if(number > B) {
            return;
        }

        dfs((number*10)+1, move+1);
        dfs(number*2, move+1);
    }
}