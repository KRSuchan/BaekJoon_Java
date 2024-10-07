package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class p_24511 {
    //    p_24511 : queuestack
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] e = new boolean[N];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) { // queue
                e[i] = true;
            }
        }
        st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (e[i]) {
                q.addFirst(x);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
            sb.append(q.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
