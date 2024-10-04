package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p_1735 {
    //    p_1735 : 분수 합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        st = new StringTokenizer(br.readLine());
        BigInteger c = new BigInteger(st.nextToken());
        BigInteger d = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        BigInteger child = a.multiply(d).add(c.multiply(b));
        BigInteger parent = b.multiply(d);
        BigInteger gcd = child.gcd(parent);
        sb.append(child.divide(gcd)).append(" ").append(parent.divide(gcd));

        System.out.println(sb);
    }
}
