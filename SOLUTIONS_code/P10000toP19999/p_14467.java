package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_14467 {
    //    p_14467 : 소가 길을 건너간 이유 1
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[11];
        Arrays.fill(cows, -1);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (cows[cow] == -1) {
                cows[cow] = pos;
            } else if (cows[cow] != pos) {
                cows[cow] = pos;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
