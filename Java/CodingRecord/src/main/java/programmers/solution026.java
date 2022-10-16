package programmers;
/*
문제 설명
정수 배열 array가 매개변수로 주어질 때,
가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
1 ≤ array의 길이 ≤ 100
0 ≤ array 원소 ≤ 1,000
array에 중복된 숫자는 없습니다.
*/

import java.util.*;
public class solution026 {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : array){
            list.add(num);
        }

        Arrays.sort(array);

        answer[0] = array[array.length-1];
        answer[1] = list.indexOf(answer[0]);

        return answer;
    }
}