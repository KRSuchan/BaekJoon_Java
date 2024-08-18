package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10205 {
    //    p_10205 : 헤라클레스와 히드라
    static int h;
    static String s;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            h = Integer.parseInt(br.readLine());
            s = br.readLine();
            int times = s.length();
            sb.append("Data Set ").append(i).append(":\n").append(cut(times)).append("\n\n");
        }
        System.out.println(sb);
    }

    private static int cut(int times) {
        for (int i = 0; i < times; i++) {
            if (s.charAt(i) == 'b') h--;
            else h++;
        }
        return Math.max(h, 0);
    }
}
