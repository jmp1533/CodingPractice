package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2629 {
    static int N, M, max = 30 * 500;
    static int arr[];
    static boolean result[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        // 추의 개수
        N= Integer.parseInt(br.readLine());
        arr= new int[N+1];
        result= new boolean[31][max+1];

        //추의 무게
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        dp(0,0);

        // 구슬 개수
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int beadWeight = Integer.parseInt(st.nextToken());

            if(beadWeight > max){
                sb.append("N ");
            }
            else {
                sb.append(result[N][beadWeight] ? "Y ":"N ");
            }
        }

        System.out.println(sb);

        br.close();
    }

    public static void dp(int idx, int weight) {
        if(result[idx][weight]) return;

        result[idx][weight]=true;
        if(idx == N) return;

        //구슬 반대편 1개 추가
        dp(idx+1, weight + arr[idx+1]);
        //현재 추 그대로
        dp(idx+1, weight);
        //구슬쪽 1개 추가
        dp(idx+1, Math.abs(weight - arr[idx+1]));
    }
}