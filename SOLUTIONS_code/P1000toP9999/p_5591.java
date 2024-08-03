package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_5591 {
    //    p_5591 : 最大の和
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // alg
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }
        int max = cur;
        for (int i = k, prev = cur; i < n; i++) {
            cur = prev - arr[i - k] + arr[i];
            max = Math.max(cur, max);
            prev = cur;
        }
        // output
        System.out.println(max);
    }
}
