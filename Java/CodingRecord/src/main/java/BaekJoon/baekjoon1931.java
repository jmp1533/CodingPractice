package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon1931 {
    public static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.end == other.end) return this.start - other.start;

            return this.end - other.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Meeting> meetings = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(startTime, endTime));
        }

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (meeting.start >= end) {
                count++;
                end = meeting.end;
            }
        }

        System.out.println(count);
    }
}