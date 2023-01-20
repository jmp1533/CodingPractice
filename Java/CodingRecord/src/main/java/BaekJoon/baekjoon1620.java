package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon1620 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        String arr[] = new String[N+1];

        for(int i=1; i<N+1; i++) {
            String s = br.readLine();

            hm.put(s, i);
            arr[i] = s;
        }

        while(0 < M) {
            String str = br.readLine();
            if(str.matches("\\d+")) {
                int idx = Integer.parseInt(str);
                sb.append(arr[idx]);
            } else {
                sb.append(hm.get(str));
            }
            sb.append("\n");

            M--;
        }

        System.out.println(sb);
        br.close();
    }
}