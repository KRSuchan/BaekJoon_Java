package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1487 {
    //    p_1487 : 물건 팔기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] purchase = new int[n];
        int[] fee = new int[n];
        for (int i = 0; i < n; i++) {
            var st = new StringTokenizer(br.readLine());
            purchase[i] = Integer.parseInt(st.nextToken());
            fee[i] = Integer.parseInt(st.nextToken());
        }
        int res = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int benefit = 0;
            for (int j = 0; j < n; j++) {
                if (purchase[i] <= purchase[j]) {
                    int b;
                    benefit += ((b = purchase[i] - fee[j]) > 0) ? b : 0;
                }
            }
            if (max < benefit) {
                res = purchase[i];
                max = benefit;
            } else if (max == benefit) {
                res = Math.min(purchase[i], res);
            }
        }
        System.out.println(res);
    }
}
