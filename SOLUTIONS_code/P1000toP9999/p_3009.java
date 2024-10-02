package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3009 {
    //    p_3009 : 네 번째 점
    public static void solution(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] xs = new int[2], ys = new int[2];
        xs[0] = Integer.parseInt(st.nextToken());
        ys[0] = Integer.parseInt(st.nextToken());
        boolean isx0 = true;
        boolean isy0 = true;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (xs[0] != x) {
                isx0 = !isx0;
                xs[1] = x;
            }
            if (ys[0] != y) {
                isy0 = !isy0;
                ys[1] = y;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(isx0 ? xs[0] : xs[1]).append(" ");
        sb.append(isy0 ? ys[0] : ys[1]);
        System.out.println(sb);
    }
}
