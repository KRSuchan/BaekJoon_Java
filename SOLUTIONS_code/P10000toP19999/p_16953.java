package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_16953 {
    //    p_16953 : A → B
    static long a, b;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    static long bfs() {
        Queue<Long> q = new LinkedList<Long>();
        q.add(a);
        while (!q.isEmpty()) {
            for (int i = 0, size = q.size(); i < size; i++) {
                long x = q.poll();
                long y1, y2;
                if (x == b) return cnt + 1;
                if ((y1 = x * 2) <= b) q.add(y1);
                if ((y2 = x * 10 + 1) <= b) q.add(y2);
            }
            cnt++;
        }
        return -1;
    }
}
