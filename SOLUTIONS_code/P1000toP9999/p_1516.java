package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1516 {
    //    p_1516 : 게임 개발
    static int N;
    static int[] cost, nextBuild, result;
    static ArrayList<ArrayList<Integer>> tree;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        cost = new int[N + 1];
        nextBuild = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            // 지어야하는 건물을 넣어 보니 지금껏 해온 그래프 next 방식이 아닌 prev 방식이라 익숙하지 않아서
            // 지을 수 있는 건물을 변경하여 next 방식으로 변경 가능하게끔 함.
            var st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int x;
            while ((x = Integer.parseInt(st.nextToken())) != -1) {
                tree.get(x).add(i);
                nextBuild[i]++;
            }
        }

        result = new int[N + 1];

        topologicalSort();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + cost[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (nextBuild[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree.get(now)) {
                nextBuild[next]--;
                result[next] = Math.max(result[next], result[now] + cost[now]);
                if (nextBuild[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
