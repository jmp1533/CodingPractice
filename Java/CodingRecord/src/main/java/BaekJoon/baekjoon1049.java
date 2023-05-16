package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1049 {
    static int N,M;
    static int pack = Integer.MAX_VALUE, piece = Integer.MAX_VALUE;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");

            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        if(piece * 6 <= pack) {
            result = piece * N;
        }
        else {
            result = (N/6) * pack;

            if((N % 6 * piece) <= pack){
                result += (N % 6) * piece;
            }
            else {
                result += pack;
            }
        }

        System.out.println(result);
        br.close();
    }
}