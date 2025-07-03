package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_10610 {
    //    p_10610 : 30
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        int sum = 0;
        int num = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            num = chars[i] - '0';
            sum += num;
            sb.append(num);
        }
        if (num != 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
