package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10902 {
    //    p_10902 : Penalty calculation
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = -1;
        int f = -1;
        int tf = -1;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (max < s) {
                tf = t;
                f = i;
                max = s;
            }
        }
        if (max == 0)
            System.out.println(0);
        else
            System.out.println(tf + (f - 1) * 20);
    }
}
