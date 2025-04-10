package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2623 {
    //    p_2623 : 음악프로그램
    static ArrayList<ArrayList<Integer>> singers;
    static int N, M;
    static int[] nextSingers;
    static ArrayList<Integer> result;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        singers = new ArrayList<>();
        nextSingers = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            singers.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 보조 PD가 담당한 가수의 수
            int cur = Integer.parseInt(st.nextToken()); // 가수들의 순서 첫번째
            for (int j = 1; j < k; j++) {  // 가수들의 순서 두번째부터
                int next = Integer.parseInt(st.nextToken());
                singers.get(cur).add(next);
                nextSingers[next]++;
                cur = next;
            }
        }
        result = new ArrayList<>();
        topologicalSort();
        if (result.size() != N) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (nextSingers[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int next : singers.get(cur)) {
                nextSingers[next]--;
                if (nextSingers[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
