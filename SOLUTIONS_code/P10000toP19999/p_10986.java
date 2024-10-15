package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10986 {
    //    p_10986 : 나머지 합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] sums = new long[N + 1];
        long[] counts = new long[M];
        long res = 0;
        for (int i = 1; i <= N; i++) {
            sums[i] = (sums[i - 1] + arr[i]) % M;
            if (sums[i] == 0) {
                res++;
            }
            counts[(int) sums[i]]++;
        }
        for (int i = 0; i < M; i++) {
            res += (counts[i] * (counts[i] - 1)) / 2;
        }
        System.out.println(res);
    }
}
