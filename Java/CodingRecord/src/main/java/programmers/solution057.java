package programmers;
/*
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
*/

import java.util.ArrayList;
import java.util.Collections;

public class solution057 {
    public int solution(int n) {
        int result = 0;
        ArrayList<Integer> list = Convert1(n);

        Collections.reverse(list);

        result = Convert2(list);

        return result;
    }

    public ArrayList<Integer> Convert1(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        while(Math.pow(3, max) <= n){
            max++;
        }

        for(int i=max; i>0; i--){
            int pow = (int) Math.pow(3, i-1);

            list.add(n / pow);
            n %= pow;
        }

        return list;
    }

    public int Convert2(ArrayList<Integer> list){
        int s = list.size() - 1;
        int result = 0;

        for(int num : list){
            result += (int) Math.pow(3, s) * num;

            s--;
        }

        return result;
    }
}