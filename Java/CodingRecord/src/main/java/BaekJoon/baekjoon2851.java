package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        int[] mushrooms = new int[10];

        for(int i = 0; i < 10; i++){
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 10; i++) {
            score += mushrooms[i];

            if(Math.abs((score-mushrooms[i])-100) < score-100) {
                score = score-mushrooms[i];
                break;
            }
        }

        System.out.println(score);
    }
}