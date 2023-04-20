package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<int[]> balloons = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        sb.append("1 ");
        int move = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N ; i++) {
            balloons.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!balloons.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    balloons.add(balloons.pollFirst());
                }

                int[] next = balloons.removeFirst();
                move = next[1];
                sb.append(next[0]).append(" ");
            } else {
                for (int i = move; i < -1; i++) {
                    balloons.addFirst(balloons.pollLast());
                }

                int[] next =balloons.removeLast();
                move = next[1];
                sb.append(next[0]).append(" ");
            }
        }

        System.out.println(sb);
    }
}