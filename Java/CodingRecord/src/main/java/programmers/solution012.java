package programmers;
/*
문제 설명
중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만,
전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
*/

public class solution012 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //격자의 총갯수 = brown+yellow
        int total = brown+yellow;

        //약수의 조합 = 가로 * 세로를 알수있다.
        //가로 >= 세로이므로 for변수는 col(세로)로 선언한다.
        //yellow가 1인경우 가로/세로는 최소 3이므로 3부터 시작한다.
        for(int col=3; col<=Math.sqrt(total); col++){

            if(0 == total%col){
                int row = total/col;

                //row에서 위/아래 2줄, col에서 좌/우 2줄을 뺀뒤 곱하면 yellow수를 알수 있다.
                //약수의 조합중 "(row-2)*(col-2) == yellow"라면 정답이다.
                if((row-2)*(col-2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }

        return answer;
    }
}