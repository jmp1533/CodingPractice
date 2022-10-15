package programmers;
/*
문제 설명
최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
최빈값이 여러 개면 -1을 return 합니다.

제한사항
0 < array의 길이 < 100
-1000 < array의 원소 < 1000
*/

import java.util.*;
public class solution025 {
    public int solution(int[] array) {
        int answer = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();

        if(1 == array.length){
            return array[0];
        }

        for(int num : array){
            hm.put(num, hm.getOrDefault(num, 1)+1);
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());

        // Value 기준으로 내림차순 정렬.
        keySet.sort((o1, o2) -> hm.get(o2) - hm.get(o1));

        int a = hm.get(keySet.get(0));
        int b = hm.get(keySet.get(1));

        answer = a > b ? keySet.get(0) : -1;

        return answer;
    }
}