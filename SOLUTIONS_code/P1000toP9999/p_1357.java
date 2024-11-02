package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1357 {
    //    p_1357 : 뒤집힌 덧셈
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(rev(st.nextToken()));
        int y = Integer.parseInt(rev(st.nextToken()));
        int z = x + y;
        System.out.println(Integer.parseInt(rev(Integer.toString(z))));
    }

    private static String rev(String val) {
        StringBuilder sb = new StringBuilder();
        for (int i = val.length() - 1; i >= 0; i--) {
            sb.append(val.charAt(i));
        }
        return sb.toString();
    }
}
