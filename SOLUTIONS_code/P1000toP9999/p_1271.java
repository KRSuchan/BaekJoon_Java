package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p_1271 {
    //    p_1271 : 엄청난 부자2
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(n.divide(m)).append("\n");
        sb.append(n.mod(m));
        System.out.print(sb);
    }
}
