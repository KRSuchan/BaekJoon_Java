package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_2252 {
    //    p_2252 : 줄 세우기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] e = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            graph.get(front).add(back);
            e[back]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < e.length; i++) {
            if (e[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            List<Integer> list = graph.get(num);

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                e[temp]--;
                if (e[temp] == 0) {
                    q.add(temp);
                }
            }
        }
        System.out.println(sb);
    }
}
