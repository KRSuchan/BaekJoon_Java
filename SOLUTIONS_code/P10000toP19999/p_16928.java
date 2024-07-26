package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_16928 {
    //    p_16928 : 뱀과 사다리 게임
    static int[] map;
    static int[] result;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 수
        int m = Integer.parseInt(st.nextToken()); // 뱀 수
        map = new int[101];
        result = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs();
        System.out.println(result[100]);
        for (int i = 0; i < 101; i++) {
            System.out.println(i + " " + result[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                int dest = (map[next] != 0) ? map[next] : next;
                if (result[dest] == 0) {
                    result[dest] = result[cur] + 1;
                    q.add(dest);
                }
            }
        }
    }
}
