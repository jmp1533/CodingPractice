package programmers;
/*
문제 설명
첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1, 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다.
두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 <denum1, num1, denum2, num2 < 1,000

입출력 예
denum1	num1	denum2	num2	result
1	2	3	4	[5, 4]
9	2	1	3	[29, 6]

입출력 예 #1
1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.

입출력 예 #2
9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.
*/

public class solution029 {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        // 분모의 최대공약수 구하기
        int gcdNum = gcd(num1, num2);
        // 분모의 최소공배수 구하기
        int lcmNum = lcm(num1, num2, gcdNum);

        // 분모에 최소공배수가 나오는 수를 확인한 후 분자를 분모에 맞추기
        int mul1 = lcmNum / num1;
        denum1 *= mul1;

        int mul2 = lcmNum / num2;
        denum2 *= mul2;

        // 분자 더하기
        int denum = denum1 + denum2;
        // 기약분수를 구하기 위한, 분자 합계와 분모의 최대공약수 구하기
        int gcdNum2 = gcd(denum, lcmNum);

        // 최대공약수로 나누기
        int[] answer = {denum / gcdNum2, lcmNum / gcdNum2};

        return answer;
    }

    //최대공약수
    public int gcd(int num1, int num2){
        boolean run = true;
        int gcdNum = 0;

        while(run){
            if(0 == num2){
                break;
            }

            if(0 != num2 || 0 != num1 % num2){
                int temp = num1;
                num1 = num2;
                num2 = temp % num2;
            }else{
                run = false;
            }
        }

        gcdNum = num1;

        return gcdNum;
    }

    //최소공배수
    public int lcm(int num1, int num2, int gcd){
        return (num1 * num2) / gcd;
    }
}