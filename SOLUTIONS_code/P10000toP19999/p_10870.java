package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10870 {
    //    p_10870 : 피보나치 수 5
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fib(Integer.parseInt(br.readLine())));
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        return n == 1 ? 1 : fib(n - 1) + fib(n - 2);
    }
}
