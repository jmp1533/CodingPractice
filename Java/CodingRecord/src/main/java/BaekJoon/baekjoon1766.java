package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1766 {
    private static int N, M;
    private static int[] level;
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        level = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            level[y]++;
        }

        Sort();
    }

    static void Sort() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < N + 1; i++) {
            if (level[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.print(number + " ");

            for (int i = 0; i < list[number].size(); i++) {
                int next = list[number].get(i);
                level[next]--;

                if (level[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}