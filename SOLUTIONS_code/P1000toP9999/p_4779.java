package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_4779 {
    //    p_4779 : 칸토어 집합
    static boolean[] isDash;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            isDash = new boolean[(int) Math.pow(3, n)];
            Arrays.fill(isDash, true);
            cantor(0, isDash.length - 1);
            for (int i = 0; i < isDash.length; i++) {
                sb.append(isDash[i] ? "-" : " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void cantor(int s, int e) {
        if (e - s <= 1) {
            return;
        }
        int split = (e - s + 1) / 3;
        int from = split + s;
        int to = split * 2 + s;
        Arrays.fill(isDash, from, to, false);
        cantor(s, from - 1);
        cantor(to, e);
    }
}
