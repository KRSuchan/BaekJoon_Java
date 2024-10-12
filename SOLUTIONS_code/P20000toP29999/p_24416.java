package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_24416 {
    //    p_24416 : 알고리즘 수업 - 피보나치 수 1
    static int a = 0, b = 0;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(a + " " + b);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            a++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            b++;
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
