package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11053 {
    //    p_11053 : 가장 긴 증가하는 부분 순열
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // init
        int[] arr = new int[n];
        int[] result = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // alg
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                }
            }
        }
        // output
        for (int i = 0; i < n; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}
