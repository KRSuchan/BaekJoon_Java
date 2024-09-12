package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_30802 {
    //    p_30802 : 웰컴 키트
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int resT = 0;
        for (int i = 0; i < 6; i++) {
            resT += (int) Math.ceil((double) sizes[i] / T);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(resT).append("\n").append(N / P).append(" ").append(N % P);
        System.out.println(sb);
    }
}
