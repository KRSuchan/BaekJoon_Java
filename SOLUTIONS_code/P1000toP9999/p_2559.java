package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2559 {
    //    p_2559 : 수열
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = 0; i < N - K; i++) {
            max = Math.max(max, sum = sum - arr[i] + arr[i + K]);
        }
        System.out.println(max);
    }
}
