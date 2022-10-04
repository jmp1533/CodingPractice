package programmers;
/*
문제 설명
Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15
자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

제한사항
n은 10,000 이하의 자연수 입니다.
입출력 예
n	result
15	4
*/

import java.util.*;

public class solution17 {
    public int solution(int n) {
        int answer = 1;

        //i가 n/2보다 큰경우 연속한 자연수의 합이 n보다 커지므로 (n/2)까지만 반복문 처리
        for(int i=1; i<=(n/2); i++){
            int sum = 0;

            for(int j=i; j<=n; j++){
                sum += j;

                if(n == sum){
                    //연속한 자연수의 합이 n과 같은경우 +1;
                    answer++;
                    break;
                }else if(n < sum ){
                    //연속한 자연수의 합이 n보다 큰경우 Break;
                    break;
                }
            }
        }

        return answer;
    }
}