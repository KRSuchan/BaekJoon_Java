package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_11582 {
    //    p_11582 : 치킨 TOP N
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        int size = N / k;
        for (int i = 0; i < N; i += size) {
            Arrays.sort(scores, i, i + size);
        }
        var sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(scores[i]).append(" ");
        }
        System.out.println(sb);
    }
}
