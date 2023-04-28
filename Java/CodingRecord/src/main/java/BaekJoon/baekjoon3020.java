package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H + 1];
        int[] bottomSum = new int[H + 1];
        int[] top = new int[H + 1];
        int[] topSum = new int[H + 1];
        int min = N;
        int minCount = 0;

        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < H + 1; i++) {
            topSum[i] = topSum[i - 1] + top[i];
            bottomSum[i] = bottomSum[i - 1] + bottom[i];
        }

        for (int i = 1; i < H + 1; i++) {
            int crush = 0;

            crush += bottomSum[H] - bottomSum[i - 1];
            crush += topSum[H] - topSum[H - i];

            if (min > crush) {
                min = crush;
                minCount = 1;
            } else if (min == crush) {
                minCount++;
            }
        }

        System.out.println(min + " " + minCount);
    }
}