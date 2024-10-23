package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_11444 {
    //    p_11444 : 피보나치 수 6
    static final long MOD = 1_000_000_007;
    static final long[][] origin = {{1, 1}, {1, 0}};

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};
        System.out.println(pow(A, N - 1)[0][0]);
    }

    private static long[][] pow(long[][] A, long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }
        long[][] ret = pow(A, exp / 2);
        ret = multiply(ret, ret);
        if (exp % 2 == 1) {
            ret = multiply(ret, origin);
        }
        return ret;
    }

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }
}
