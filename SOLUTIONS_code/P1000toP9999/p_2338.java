package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p_2338 {
    //    p_2338 : 긴자리 계산
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        String sb = A.add(B) + "\n" +
                A.subtract(B) + "\n" +
                A.multiply(B);
        System.out.println(sb);
    }
}
