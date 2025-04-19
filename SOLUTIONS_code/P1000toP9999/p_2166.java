package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2166 {
    //    p_2166 : 다각형의 면적
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] xs = new long[N + 1];
        long[] ys = new long[N + 1];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        xs[N] = xs[0];
        ys[N] = ys[0];
        double size = 0;
        for (int i = 0; i < N; i++) {
            size += xs[i] * ys[i + 1];
            size -= xs[i + 1] * ys[i];
        }

        System.out.printf("%.1f", Math.abs(size / 2));
    }
}
