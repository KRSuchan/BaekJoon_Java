package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2470 {
    //    p_2470 : 두 용액
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int[] liquids = new int[n];
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);
        int i = 0;
        int j = liquids.length - 1;
        int gap = Integer.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;
        while (i < j) {
            int sum = liquids[i] + liquids[j];
            int abs = Math.abs(sum);
            if (abs < gap) {
                gap = abs;
                res1 = liquids[i];
                res2 = liquids[j];
            }
            if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(res1 + " " + res2);
    }
}
