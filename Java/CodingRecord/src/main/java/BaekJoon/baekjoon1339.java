package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon1339 {
    private static List<Character> alpabet = new ArrayList<>();
    private static String[] words;
    private static int N, result = 0;
    private static int[] alpabetNumber;
    private static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();

            for (int j = 0; j < words[i].length(); j++) {
                if (!alpabet.contains(words[i].charAt(j))) {
                    alpabet.add(words[i].charAt(j));
                }
            }
        }

        alpabetNumber = new int[alpabet.size()];

        dfs(0);

        System.out.println(result);

        br.close();
    }

    public static void dfs(int index) {
        if (index == alpabet.size()) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int num = 0;

                for (int j = 0; j < words[i].length(); j++) {
                    num = (num * 10) + alpabetNumber[alpabet.indexOf(words[i].charAt(j))];
                }

                sum += num;
            }

            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            alpabetNumber[index] = i;

            dfs(index + 1);

            visited[i] = false;
            alpabetNumber[index] = 0;
        }
    }
}