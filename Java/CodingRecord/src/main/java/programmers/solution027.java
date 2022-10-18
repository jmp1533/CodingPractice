package programmers;
/*
문제 설명
약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 100
*/

import java.util.ArrayList;
import java.util.Arrays;

public class solution027 {
    public int solution(int n) {
        int answer = 0;

        for(int a=1; a<=n; a++){
            int count = 0;

            for(int b=1; b<=Math.sqrt(a); b++){
                if(0 == a%b){
                    count++;

                    if(a/b != b){
                        count++;
                    }
                }

                if(3 <= count){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}