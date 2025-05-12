package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1043 {
    //    p_1043 : 거짓말
    static int[] parents;
    static ArrayList<Integer> knList;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int kn = Integer.parseInt(st.nextToken());
        knList = new ArrayList<>();
        if (kn == 0) {
            System.out.println(M);
            return;
        }
        for (int i = 0; i < kn; i++) {
            knList.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<ArrayList<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            partyList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList.get(i).add(x);
            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList.get(i).add(y);
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int num : partyList.get(i)) {
                if (knList.contains(find(num))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (knList.contains(y)) {
            int temp = x;
            x = y;
            y = temp;
        }
        parents[y] = x;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
