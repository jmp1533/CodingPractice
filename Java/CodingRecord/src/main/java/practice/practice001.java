package practice;
/*
문자열 회문

adeeeda => YES
HeLLo => NO
*/

public class practice001 {
    //charAt() 비교
    public String solution1(String str) {
        String answer = "YES";
        str = str.toUpperCase(); // 대문자 변경

        int len = str.length();

        for (int i=0; i<len/2; i++) { // 문자열의 중간까지만 검사
            if (str.charAt(i)!=str.charAt(len-i-1)) return "NO";
        }

        return answer;
    }

    //StringBuilder(), equalsIgnoreCase()
    public String solution2(String str) {

        String answer = "NO";
        String temp = new StringBuilder(str).reverse().toString();

        // equalsIgnoreCase : 대소문자 무시
        if (str.equalsIgnoreCase(temp)) answer = "YES";
        return answer;
    }

    //StringBuilder(), equals()
    public String solution3(String str) {

        str = str.toLowerCase(); // 소문자로
        String reversed = new StringBuilder(str).reverse().toString();

        if (!str.equals(reversed)) return "NO";

        else return "YES";
    }
}