package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_23278 {
    //    p_23278 : 영화 평가
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int L = Integer.parseInt(st1.nextToken());
        int H = Integer.parseInt(st1.nextToken());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(scores);
        double sum = 0;
        for (int i = L; i < N - H; i++) {
            sum += scores[i];
        }
        System.out.printf("%.10f", sum / (N - H - L));
    }
}
