package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Move implements Comparable<Move> {
    int start;
    int end;
    int weight;

    Move(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Move m) {
        return weight - m.weight;
    }
}

public class baekjoon1647 {
    static int[] parent;
    static ArrayList<Move> moves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        moves = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            moves.add(new Move(start, end, weight));
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(moves);

        int sum = 0;
        int cost = 0;
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);

            if (find(move.start) != find(move.end)) {
                sum += move.weight;

                union(move.start, move.end);

                cost = move.weight;
            }
        }

        bw.write((sum - cost) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}