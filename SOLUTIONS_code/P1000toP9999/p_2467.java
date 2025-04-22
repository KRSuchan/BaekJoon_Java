package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2467 {
    //    p_2467 : 용액
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        int j = N - 1;
        int sum = Integer.MAX_VALUE;
        int liq1 = 0;
        int liq2 = 0;
        while (i < j) {
            int mix = arr[i] + arr[j];
            if (Math.abs(mix) < Math.abs(sum)) {
                sum = mix;
                liq1 = arr[i];
                liq2 = arr[j];
            }
            if (mix < 0) {
                i++;
            } else if (mix > 0) {
                j--;
            } else {
                break;
            }
        }
        System.out.printf("%d %d", liq1, liq2);
    }
}
