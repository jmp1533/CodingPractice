package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon6198 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> building = new Stack<>();
        long result = 0L;

        int N = Integer.parseInt(br.readLine());
        building.push(Long.parseLong(br.readLine()));

        for (int i = 1; i < N; i++){
            Long keeper = Long.parseLong(br.readLine());

            if (keeper >= building.peek()){
                while (!building.isEmpty() && keeper >= building.peek()){
                    building.pop();
                }
            }

            result += building.size();
            building.push(keeper);
        }

        System.out.print(result);
    }
}