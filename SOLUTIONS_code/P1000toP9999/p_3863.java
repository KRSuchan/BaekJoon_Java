package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3863 {
    //    p_3863 : 행복한 전화 통화
    static int s = 0;
    static int e = 1;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                st.nextToken();
                int s = Integer.parseInt(st.nextToken());
                int e = s + Integer.parseInt(st.nextToken());
                arr[i][0] = s;
                arr[i][1] = e;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int ps = Integer.parseInt(st.nextToken());
                int pe = ps + Integer.parseInt(st.nextToken());
                int res = 0;
                for (int j = 0; j < N; j++) {
                    if (ps <= arr[j][s] && arr[j][s] < pe) { // ps <= s 이면 s < pe
                        res++;
                    } else if (arr[j][s] <= ps && ps < arr[j][e]) { // s <= ps 이면 ps < e
                        res++;
                    }
                }
                sb.append(res).append("\n");
            }
        }
        System.out.print(sb);
    }
}
