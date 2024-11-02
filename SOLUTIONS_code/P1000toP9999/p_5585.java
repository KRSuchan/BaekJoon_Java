package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5585 {
    //    p_5585 : 거스름돈
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int rest = 1000 - n;
        int cnt = 0;
        for (int i = 0; i < coins.length; i++) {
            cnt += rest / coins[i];
            rest = rest % coins[i];
        }
        System.out.println(cnt);
    }
}
