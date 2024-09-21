package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_28324 {
    //    p_28324 : 스케이트 연습
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] v = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }
        long idx = 1;
        long res = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (v[i] > idx) {
                res += idx;
                idx++;
            } else {
                res += v[i];
                idx = v[i] + 1;
            }
        }
        System.out.println(res);
    }
}
