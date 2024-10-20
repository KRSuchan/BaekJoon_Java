package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11401 {
    //    p_11401 : 이항 계수 3
    static int MOD = 1_000_000_007;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long num = factorial(N);
        long den = factorial(K) * factorial(N - K) % MOD;
        System.out.println(num * pow(den, MOD - 2) % MOD);
    }

    private static long factorial(long n) {
        long fact = 1L;
        while (n > 1) {
            fact = fact * n % MOD;
            n--;
        }
        return fact;
    }

    private static long pow(long n, long exp) {
        if (exp == 1) return n % MOD;
        long t = pow(n, exp / 2);
        if (exp % 2 == 1) {
            return (t * t % MOD) * n % MOD;
        }
        return t * t % MOD;
    }
}
