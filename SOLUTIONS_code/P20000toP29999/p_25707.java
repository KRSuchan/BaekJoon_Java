package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_25707 {
    //    p_25707 : 팔찌 만들기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] beads = new int[N];
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(beads);
        int sumOfDiff = 0;
        for (int i = 1; i < N; i++) {
            sumOfDiff += beads[i] - beads[i - 1];
        }
        sumOfDiff += beads[N - 1] - beads[0];
        System.out.println(sumOfDiff);
    }
}
