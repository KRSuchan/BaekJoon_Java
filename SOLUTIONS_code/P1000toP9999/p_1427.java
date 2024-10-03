package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class p_1427 {
    //    p_1427 : 소트인사이드
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] res = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - '0';
        }
        Arrays.sort(res, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int x : res) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}
