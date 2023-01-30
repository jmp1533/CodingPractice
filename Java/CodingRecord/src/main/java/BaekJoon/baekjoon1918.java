package BaekJoon;
/*

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        //우선순위 저장
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('(', 0);
        hm.put('+', 1);
        hm.put('-', 1);
        hm.put('*', 2);
        hm.put('/', 2);

        for(int i = 0; i < N; i++) {
            char ch = str.charAt(i);

            if('A'<=ch && ch<='Z') {
                sb.append(ch);
            }
            else {
                switch(ch) {
                    case '(' :
                        st.push(ch);
                        break;
                    case ')' : // ) 가 나올 때까지 출력
                        while(!st.isEmpty() && st.peek()!='('){
                            sb.append(st.pop());
                        }

                        if(!st.isEmpty() && st.peek()=='('){
                            st.pop();
                        }

                        break;
                    default :
                        while(!st.isEmpty() && hm.get(st.peek())>=hm.get(ch)){
                            sb.append(st.pop());
                        }

                    st.push(ch);
                }
            }
        }

        // 남은 연산자
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        System.out.println(sb.toString());
    }
}