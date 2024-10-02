package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2581 {
    //    p_2581 : 소수
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        boolean gotMin = false;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (!gotMin) {
                    min = i;
                    gotMin = true;
                }
            }
        }
        if (sum != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(sum).append("\n");
            sb.append(min);
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
