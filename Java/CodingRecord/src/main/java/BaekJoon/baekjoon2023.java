package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2023 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs("", 0);
    }

    public static void dfs(String s, int len) {
        if (len == N) {
            System.out.println(s);
            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(check(Integer.parseInt(s + i))) {
                dfs(s + i, len + 1);
            }
        }
    }

    public static boolean check(int num) {
        if(num == 1){
            return false;
        }

        int sqrtNum = (int) Math.sqrt(num);

        for(int i = 2; i <= sqrtNum; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}