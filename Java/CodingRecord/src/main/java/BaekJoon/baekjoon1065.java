package BaekJoon;
/*
문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
*/

import java.util.Scanner;

public class baekjoon1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int result = 99;

        if(N < 100) {
            System.out.println(N);
        } else {
            for(int i = 100 ; i <= N ; i++) {
                result += Check(i);
            }

            System.out.println(result);
        }

        sc.close();
    }

    private static int Check(int num) {
        int a = num / 100;
        int b = num % 100 / 10;
        int c = num % 10;

        return b*2 == a + c ? 1 : 0;
    }
}