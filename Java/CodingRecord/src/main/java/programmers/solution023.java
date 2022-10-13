package programmers;
/*
문자열 my_string이 매개변수로 주어집니다.
my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
*/

public class solution023 {
    public String solution(String my_string) {
        String answer = "";

        StringBuffer sb = new StringBuffer(my_string);

        //문자열 뒤집기
        answer = sb.reverse().toString();

        return answer;
    }
}