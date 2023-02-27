package BaekJoon;
/*
문제
상근이의 상상의 친구 외계인은 손가락을 수십억개 가지고 있다.
어느 날 외계인은 기타가 치고 싶었고, 인터넷에서 간단한 멜로디를 검색했다. 이제 이 기타를 치려고 한다.

보통 기타는 1번 줄부터 6번 줄까지 총 6개의 줄이 있고, 각 줄은 P개의 프렛으로 나누어져 있다.
프렛의 번호도 1번부터 P번까지 나누어져 있다.

멜로디는 음의 연속이고, 각 음은 줄에서 해당하는 프렛을 누르고 줄을 튕기면 연주할 수 있다.
예를 들면, 4번 줄의 8번 프렛을 누르고 튕길 수 있다. 만약, 어떤 줄의 프렛을 여러 개 누르고 있다면, 가장 높은 프렛의 음이 발생한다.

예를 들어, 3번 줄의 5번 프렛을 이미 누르고 있다고 하자.
이때, 7번 프렛을 누른 음을 연주하려면, 5번 프렛을 누르는 손을 떼지 않고 다른 손가락으로 7번 프렛을 누르고 줄을 튕기면 된다.
여기서 2번 프렛의 음을 연주하려고 한다면, 5번과 7번을 누르던 손가락을 뗀 다음에 2번 프렛을 누르고 연주해야 한다.

이렇게 손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다고 한다.
어떤 멜로디가 주어졌을 때, 손가락의 가장 적게 움직이는 회수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 멜로디에 포함되어 있는 음의 수 N과 한 줄에 있는 프렛의 수 P가 주어진다. (N ≤ 500,000, 2 ≤ P ≤ 300,000)

다음 N개 줄에는 멜로디의 한 음을 나타내는 두 정수가 주어진다.
첫 번째 정수는 줄의 번호이고 두 번째 정수는 그 줄에서 눌러야 하는 프렛의 번호이다. 입력으로 주어진 음의 순서대로 기타를 연주해야 한다.

출력
첫째 줄에 멜로디를 연주하는데 필요한 최소 손가락 움직임을 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack = new Stack[N+1];

        for(int i=0; i<=N; i++){
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            if(stack[line].size() == 0) {
                result++;

                stack[line].push(fret);
                continue;
            }

            while(stack[line].peek() > fret) {
                result++;

                stack[line].pop();
                if(stack[line].size()==0) break;
            }

            if(stack[line].size() != 0 && stack[line].peek() == fret) continue;

            result++;
            stack[line].push(fret);
        }

        System.out.println(result);
    }
}