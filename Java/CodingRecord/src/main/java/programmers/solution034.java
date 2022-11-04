package programmers;
/*
문제 설명
정수 배열 numbers가 주어집니다.
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
입출력 예
numbers	result
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]
*/

import java.util.*;
public class solution034 {
    public int[] solution(int[] numbers) {
        Set<Integer> hs = new HashSet<>();

        for(int i=0; i< numbers.length-1; i++){
            for(int j=i+1; j <numbers.length; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }

        int answer[] = new int[hs.size()];
        int idx = 0;

        for(Integer num : hs){
            answer[idx++] = num;
        }

        Arrays.sort(answer);

        return answer;
    }
}