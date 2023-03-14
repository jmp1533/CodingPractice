package BaekJoon;
/*
문제
민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다.
우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.

어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.

친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다.
각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다.
다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다.
친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.

출력
친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon4195 {
    static int parent[];
    static int count[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<test; i++) {
            int F = Integer.parseInt(br.readLine());
            int number = 0;
            parent = new int[2 * F];
            count = new int[2 * F];

            Arrays.fill(count, 1);

            for (int j = 0; j < 2 * F; j++){
                parent[j] = j;
            }

            Map<String, Integer> name = new HashMap<>();
            for (int j=0; j<F; j++) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!name.containsKey(name1))
                    name.put(name1, number++);

                if (!name.containsKey(name2))
                    name.put(name2, number++);

                int n1 = name.get(name1);
                int n2 = name.get(name2);

                union(n1, n2);

                sb.append(count[find(n1)] + "\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static int find(int n) {
        if(parent[n] == n)
            return n;

        return parent[n] = find(parent[n]);
    }

    public static void union(int n1, int n2) {
        int f1 = find(n1);
        int f2 = find(n2);

        if(f1 > f2) {
            parent[f1] = f2;
            count[f2] += count[f1];
            count[f1] = 0;
        }
        else if(f1 < f2) {
            parent[f2] = f1;
            count[f1] += count[f2];
            count[f2] = 0;
        }
    }
}