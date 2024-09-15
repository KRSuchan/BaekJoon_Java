package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_23885 {
    //    p_23885 : 비숍 투어
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        boolean isStartEven = (sx + sy) % 2 == 0;
        boolean isEndEven = (ex + ey) % 2 == 0;

        if (N == 1 || M == 1) {
            System.out.println(sx == ex && sy == ey ? "YES" : "NO");
        } else if (isStartEven == isEndEven) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
