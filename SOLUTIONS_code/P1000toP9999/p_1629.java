package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1629 {
    //    p_1629 : 곱셈
    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b));
    }

    private static long pow(long num, long exp) {
        if (exp == 1) return num % c;
        long tmp = pow(num, exp / 2);
        if (exp % 2 == 1) return (tmp * tmp % c) * num % c;
        return tmp * tmp % c;
    }
}
