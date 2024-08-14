package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_9251 {
    //    p_9251 : LCS
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        // alg
        int[][] c = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
        // output
        System.out.println(c[c.length - 1][c[0].length - 1]);
    }
}
