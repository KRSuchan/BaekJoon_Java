package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1940 {
    //    p_1940 : 주몽
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(m);
        int cnt = 0;
        for (int i = 0, j = N - 1; i < j; ) {
            if (m[i] + m[j] > M) {
                j--;
            } else if (m[i] + m[j] == M) {
                i++;
                j--;
                cnt++;
            } else {
                i++;
            }
        }
        System.out.println(cnt);
    }
}
