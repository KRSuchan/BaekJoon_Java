package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p_1247 {
    //    p_1247 : 부호
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < N; i++) {
                BigInteger num = new BigInteger(br.readLine());
                sum = sum.add(num);
            }
            int compare = sum.compareTo(BigInteger.ZERO);
            switch (compare) {
                case 0 -> sb.append("0\n");
                case 1 -> sb.append("+\n");
                case -1 -> sb.append("-\n");
            }
        }
        System.out.print(sb);
    }
}
