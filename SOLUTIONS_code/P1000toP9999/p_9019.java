package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_9019 {
    //    p_9019 : DSLR
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.print(sb);
    }

    public void bfs() {
        Queue<Register> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        q.add(new Register(n, ""));
        visited[n] = true;
        while (!q.isEmpty()) {
            Register r = q.poll();
            char[] cmd = {'D', 'S', 'L', 'R'};
            int[] dslr = {r.D(), r.S(), r.L(), r.R()};
            if (r.num == m) {
                sb.append(r.command).append("\n");
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = dslr[i];
                if (!visited[nr]) {
                    q.add(new Register(dslr[i], r.command + cmd[i]));
                    visited[nr] = true;
                }
            }
        }
    }

    static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        public int D() {
            return (num * 2) % 10000;
        }

        public int S() {
            return num == 0 ? 9999 : num - 1;
        }

        public int L() {
            return num % 1000 * 10 + num / 1000;
        }

        public int R() {
            return num % 10 * 1000 + num / 10;
        }
    }
}
