package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon1744 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> addPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> subtractionPQ = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        int result = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) zero++;
            else if (num == 1) one++;
            else if (num > 1) addPQ.offer(num);
            else subtractionPQ.offer(num);
        }

        while (addPQ.size() > 1) {
            result += addPQ.poll() * addPQ.poll();
        }

        if (!addPQ.isEmpty()) result += addPQ.poll();

        while (subtractionPQ.size() > 1) {
            result += subtractionPQ.poll() * subtractionPQ.poll();
        }

        if (!subtractionPQ.isEmpty() && zero == 0) {
            result += subtractionPQ.poll();
        }

        result += one;

        System.out.println(result);
    }
}