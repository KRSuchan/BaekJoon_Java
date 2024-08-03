package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p_8611 {
    //    p_8611 : 팰린드롬 숫자 (java 11에서 컴파일 오류)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        BigInteger n = new BigInteger(s);
        for (int i = 2; i <= 10; i++) {
            String converted = n.toString(i);
            if (isPalindrome(converted)) {
                sb.append(i).append(" ").append(converted).append("\n");
            }
        }
        System.out.print(sb.isEmpty() ? "NIE" : sb);
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
