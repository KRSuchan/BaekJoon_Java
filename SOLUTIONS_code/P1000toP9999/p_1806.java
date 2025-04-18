package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1806 {
    //    p_1806 : 부분합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int from = 0;
        int to = 0;
        while (from <= N && to <= N) {
            if (sum >= S && min > to - from) {
                min = to - from;
            }
            if (sum < S) {
                sum += arr[to];
                to++;
            } else {
                sum -= arr[from];
                from++;
            }
        }
        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
