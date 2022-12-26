package BaekJoon;
/*
문제
3개의 시간조절용 버튼 A B C가 달린 전자레인지가 있다.
각 버튼마다 일정한 시간이 지정되어 있어 해당 버튼을 한번 누를 때마다 그 시간이 동작시간에 더해진다.
버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.

냉동음식마다 전자레인지로 요리해야할 시간 T가 초단위로 표시되어 있다.
우리는 A, B, C 3개의 버튼을 적절히 눌러서 그 시간의 합이 정확히 T초가 되도록 해야 한다.
단 버튼 A, B, C를 누른 횟수의 합은 항상 최소가 되어야 한다. 이것을 최소버튼 조작이라고 한다.

만일 요리시간이 100초라고 하면(T=100) B를 1번, C는 4번 누르면 된다.
이와 다르게 C를 10번 눌러도 100초가 되지만 이 경우 10번은 최소 횟수가 아니기 때문이 답이 될 수 없다.
이 경우 B 1번, C 4번, 총 5번이 최소버튼 조작이다. 그리고 T=234와 같이 3개의 버튼으로 시간을 정확히 맞출 수 없는 경우도 있다.
여러분은 주어진 요리시간 T초를 맞추기 위한 최소버튼 조작 방법을 구하는 프로그램을 작성해야 한다.

입력
첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.

출력
여러분은 T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다. 각각의 횟수 사이에는 빈 칸을 둔다. 해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다. 만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.

서브태스크
번호	배점	제한
1	30
T ≤ 60

2	30
T ≤ 300

3	40
T ≤ 10,000
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int time = Integer.parseInt(br.readLine()); //요리시간
        int[] sec = {300, 60, 10};//A, B, C에 지정된 시간(초)
        int[] answer = new int[3];

        for(int i = 0; i < 3; i++) {
            if(time >= sec[i]) {
                answer[i] = time / sec[i];
                time %= sec[i];
            }
        }

        if(time != 0) {
            //초(time)를 맞출 수 없는 경우
            sb.append(-1);
        }else {
            for(int num : answer) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}