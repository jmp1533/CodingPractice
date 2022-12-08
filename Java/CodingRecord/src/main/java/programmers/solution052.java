package programmers;
/*
문제 설명
영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ score[0], score[1] ≤ 100
1 ≤ score의 길이 ≤ 10

score의 원소 길이는 2입니다.
score는 중복된 원소를 갖지 않습니다.
*/

import java.util.*;
public class solution052 {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        List<ScoreInfo> list = new ArrayList<ScoreInfo>();

        for (int i = 0; i < score.length; i++) {
            list.add(new ScoreInfo(score[i][0], score[i][1], i));
        }

        list.sort(null);

        double avgScore = list.get(0).getAvg();
        int rank = 1;
        int count = 1;

        for (ScoreInfo scoreInfo : list) {
            if (avgScore > scoreInfo.getAvg()) {
                avgScore = scoreInfo.getAvg();
                rank = count;
            }

            int index = scoreInfo.getIndex();
            answer[index] = rank;

            count++;
        }

        return answer;
    }
}

class ScoreInfo implements Comparable<ScoreInfo> {
    private int eScore, mScore, index;
    private double avg;

    public ScoreInfo(int eScore, int mScore, int index) {
        this.eScore = eScore;
        this.mScore = mScore;
        this.index = index;

        this.avg = (eScore + mScore) / 2.0;
    }

    public double getAvg() {
        return avg;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(ScoreInfo other) {
        double avg1 = this.getAvg();
        double avg2 = other.getAvg();

        if (avg1 > avg2) return -1;
        else if (avg1 < avg2) return 1;

        return 0;
    }
}