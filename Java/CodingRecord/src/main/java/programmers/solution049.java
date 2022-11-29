package programmers;
/*
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.

입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
*/

public class solution049 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gdc(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    public int gdc(int n, int m){
        if(n < m){ // 유클리드 호제법 조건
            int temp = n;
            n = m;
            m = temp;
        }

        while(0 != m){ // 유클리드 호제법
            int temp = n%m;
            n = m;
            m = temp;
        }

        return n;
    }

    public int lcm(int n, int m){
        return n*m / gdc(n, m);
    }
}