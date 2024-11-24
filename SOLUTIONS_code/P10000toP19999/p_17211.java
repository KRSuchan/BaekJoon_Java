package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_17211 {
    //    p_17211 : 좋은 날 싫은 날
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int now = Integer.parseInt(st1.nextToken());

        double gg = Double.parseDouble(st2.nextToken());
        double gb = Double.parseDouble(st2.nextToken());
        double bg = Double.parseDouble(st2.nextToken());
        double bb = Double.parseDouble(st2.nextToken());

        double good = 0;
        double bad = 0;
        if (now == 0) {
            good = 1;
        } else {
            bad = 1;
        }

        for (int i = 0; i < N; i++) {
            double prev = good;
            good = good * gg + bad * bg;
            bad = prev * gb + bad * bb;
        }
        System.out.println((int) (good * 1000));
        System.out.println((int) (bad * 1000));
    }
}
