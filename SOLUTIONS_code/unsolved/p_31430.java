package SOLUTIONS_code.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_31430 {
    //    p_31430 : A+B - 투 스텝
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if (T == 1) {
            var st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            String result = encode(A + B);
            System.out.println(result);
        } else if (T == 2) {
            String encodedString = br.readLine();
            long sum = decode(encodedString);
            System.out.println(sum);
        }
    }

    private static String encode(long sum) {
        StringBuilder result = new StringBuilder();
        while (sum != 0) {
            result.append((char) ('a' + (sum % 26)));
            sum /= 26;
        }
        while (result.length() < 13) {
            result.append('-');
        }
        return result.toString();
    }

    private static long decode(String encoded) {
        long decoded = 0;
        long multiplier = 1;
        for (char c : encoded.toCharArray()) {
            if (c != '-') {
                decoded += (c - 'a') * multiplier;
                multiplier *= 26;
            }
        }
        return decoded;
    }
}
