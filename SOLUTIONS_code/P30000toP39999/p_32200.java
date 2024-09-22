package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_32200 {
    //    p_32200 : 항해
    public static void unsolved(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sandwich = new int[N];
        for (int i = 0; i < N; i++) {
            sandwich[i] = Integer.parseInt(st.nextToken());
        }

        int eat = 0;
        long rest = 0;
        for (int i = 0; i < N; i++) {
            int n = sandwich[i];
            int e = n / X;
            int r = n % X;
            eat += e;
            if (e != 0) {
                if (n / e < X || n / e >= Y) {
                    rest += n / e - Y + n % e;
                }
            } else {
                rest += r;
            }
            System.out.println("n = " + n);
            System.out.println("eat = " + eat);
            System.out.println("rest = " + rest);
            System.out.println();
        }
        System.out.println(eat);
        System.out.println(rest);
    }
}
