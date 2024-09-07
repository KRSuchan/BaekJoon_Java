package SOLUTIONS_code.P30000toP39999;

import java.io.*;
import java.util.StringTokenizer;

public class p_31881 {
    //    p_31881 : K512에 바이러스 퍼뜨리기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] infected = new boolean[N + 1];

        int cnt = N;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int idx;
            switch (q) {
                case 1:
                    idx = Integer.parseInt(st.nextToken());
                    if (!infected[idx]) cnt--;
                    infected[idx] = true;
                    break;
                case 2:
                    idx = Integer.parseInt(st.nextToken());
                    if (infected[idx]) cnt++;
                    infected[idx] = false;
                    break;
                case 3:
                    sb.append(cnt).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
