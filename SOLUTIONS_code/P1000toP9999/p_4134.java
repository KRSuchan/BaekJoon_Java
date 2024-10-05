package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p_4134 {
    //    p_4134 : 다음 소수
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            BigInteger x = new BigInteger(br.readLine());
            sb.append(x.isProbablePrime(1) ? x : x.nextProbablePrime()).append("\n");
        }
        System.out.println(sb);
    }
}
