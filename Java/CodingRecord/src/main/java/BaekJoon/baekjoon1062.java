package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1062 {
    static int N;
    static int K;
    static String[] words;
    static boolean[] alphabet = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        if (K >= 5) {
            dfs(0, 0);
        }

        System.out.println(max);
    }

    public static void dfs(int index, int cnt) {
        if (cnt + 5 == K) {

            int check = 0;
            for (int i = 0; i < N; i++) {
                char[] word = words[i].toCharArray();
                boolean flag = true;

                for (char c: word) {
                    if (!alphabet[c - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    check++;
                }
            }

            max = Math.max(max, check);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (alphabet[i]) {
                continue;
            }

            alphabet[i] = true;

            dfs(i + 1, cnt + 1);

            alphabet[i] = false;
        }
    }
}