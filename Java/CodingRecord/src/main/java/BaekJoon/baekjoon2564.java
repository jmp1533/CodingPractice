package BaekJoon;
/*
문제
동근이는 무인 경비 회사 경비원으로 항상 대기하고 있다가 호출이 들어오면 경비차를 몰고 그 곳으로 달려가야 한다.
동근이가 담당하고 있는 곳은 직사각형 모양의 블록으로 블록 중간을 가로질러 차가 통과할만한 길이 없다.
이 블록 경계에 무인 경비를 의뢰한 상점들이 있다.

예를 들어 가로의 길이가 10, 세로의 길이가 5인 블록의 경계에 무인 경비를 의뢰한 3개의 상점이 있다고 하자.
<그림 1>과 같이 이들은 1, 2, 3으로 표시되어 있고, 동근이는 X로 표시한 위치에 있다.

1번 상점에서 호출이 들어 왔을 때 동근이가 블록을 시계방향으로 돌아 이동하면 이동 거리가 12가 된다.
반면 반시계방향으로 돌아 이동하면 이동 거리는 18이 된다.
따라서 동근이가 1번 상점으로 가는 최단 거리는 12가 된다.
마찬가지로 동근이의 위치에서 2번 상점까지의 최단 거리는 6, 3번 상점까지의 최단 거리는 5가 된다.

블록의 크기와 상점의 개수 및 위치 그리고 동근이의 위치가 주어질 때 동근이의 위치와 각 상점 사이의 최단 거리의 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다.
둘째 줄에 상점의 개수가 주어진다. 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다.
이어 한 줄에 하나씩 상점의 위치가 주어진다.
상점의 위치는 두 개의 자연수로 표시된다. 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다.
둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다.
마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.

출력
첫째 줄에 동근이의 위치와 각 상점 사이의 최단 거리의 합을 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int storeCnt = Integer.parseInt(br.readLine());
        int[] dists = new int[storeCnt + 1];

        for(int i = 0; i < storeCnt+1; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            int dist = 0;

            switch(dir){
                case 1:
                    dist = val;
                    break;
                case 2:
                    dist = 2*W + H - val;
                    break;
                case 3:
                    dist = 2*(W + H) - val;
                    break;
                case 4:
                    dist = W + val;
                    break;
            }

            dists[i] = dist;
        }

        int loc = dists[storeCnt];
        int sum = 0;
        for(int i = 0; i < storeCnt; i++) {
            int clockWise = Math.abs(loc - dists[i]);
            sum += Math.min(clockWise, 2 * (W+H) - clockWise);
        }

        System.out.println(sum);
    }
}