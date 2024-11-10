package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_26070 {
    //    p_26070 : 곰곰이와 학식
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = Integer.parseInt(st.nextToken());

        long res = 0;

        long chicken = Math.min(A, X);
        res += chicken;
        A -= chicken;
        X -= chicken;
        Y += X / 3;
        X %= 3;

        long pizza = Math.min(B, Y);
        res += pizza;
        B -= pizza;
        Y -= pizza;
        Z += Y / 3;
        Y %= 3;

        long hamburger = Math.min(C, Z);
        res += hamburger;
        C -= hamburger;
        Z -= hamburger;
        X += Z / 3;
        Z %= 3;

        chicken = Math.min(A, X);
        res += chicken;
        A -= chicken;
        X -= chicken;
        Y += X / 3;
        X %= 3;

        pizza = Math.min(B, Y);
        res += pizza;
        B -= pizza;
        Y -= pizza;

        System.out.println(res);
    }
}
