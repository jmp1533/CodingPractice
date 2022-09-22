package programmers;
/*
문제 설명
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한 사항
n은 0 이상 3000이하인 정수입니다.

입출력 예 #1
12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

입출력 예 #2
5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
*/

import java.util.ArrayList;
import java.util.List;

public class solution7 {
    public int solution(int n) {
        int answer = 0;

        //Math.sqrt(n) : n의 제곱근까지만 돌면 약수를 모두 알수있다.
        for(int i=1; i<=Math.sqrt(n); i++){

            if(0 == n%i){
                answer += i;

                //n이 10이고 i가 2라면 몫(n/i)인 5를 알수 있다.
                if(n/i != i){
                    answer += n/i;
                }
            }
        }

        return answer;
    }
}