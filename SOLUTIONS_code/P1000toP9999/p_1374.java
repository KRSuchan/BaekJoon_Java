package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1374 {
    //    p_1374 : 강의실
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            st.nextToken();
            times.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(times);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= times.get(i).s) {
                pq.poll();
            }
            pq.add(times.get(i).e);
            cnt = Math.max(cnt, pq.size());
        }
        System.out.println(cnt);
    }

    static class Time implements Comparable<Time> {
        int s;
        int e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time t) {
            if (this.s == t.s) {
                return this.e - t.e;
            }
            return this.s - t.s;
        }
    }
}
