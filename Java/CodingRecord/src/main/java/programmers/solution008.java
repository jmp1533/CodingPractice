package programmers;
/*
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.

입출력 예
n	return
12345	[5,4,3,2,1]
*/

public class solution008 {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        int i = 0;

        while(n > 0){
            //일의자리 숫자부터 담기
            answer[i]=(int)(n%10); //1234 -> 나머지 4 -> 3 -> 2 ->1
            n/=10; // n=1234 -> 123 -> -> 12 -> 1

            i++;
        }

        return answer;
    }
}