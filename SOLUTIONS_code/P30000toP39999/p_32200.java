package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_32200 {
    //    p_32200 : 항해
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int eat = 0;
        int rest = 0;
        int diff = Y - X;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int e = n / X;
            int r = n % X;
            eat += e;
            if (e == 0) {
                rest += r;
            } else if (r > (e * diff)) {
                rest += r - (e * diff); // 직접 식 유도함...
            }
        }
        System.out.println(eat);
        System.out.println(rest);
    }
}
