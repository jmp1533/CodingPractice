package BaekJoon;
/*

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int budget = Integer.parseInt(br.readLine());
        int[] region = new int[N];

        for(int i = 0; i < N; i++) {
            region[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(region);

        int limit = 0;
        for(int i = 0; i < N; i++){
            if((region[i] * (N-i)) < budget){
                budget -= region[i];
            }else{
                limit = budget / (N-i); break;
            }
        }

        if(limit == 0){
            limit = region[N-1];
        }

        System.out.println(limit);
    }
}