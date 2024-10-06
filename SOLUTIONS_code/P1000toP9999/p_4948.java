package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_4948 {
    //    p_4948 : 베르트랑 공준
    static boolean[] prime = new boolean[246913];

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prime();
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int cnt = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (!prime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    private static void prime() {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
