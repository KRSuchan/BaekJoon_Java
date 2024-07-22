package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5525 {
    //    p_5525번 : IOIOI
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // O 개수
        int m = Integer.parseInt(br.readLine()); // 문장 길이
        int result = 0;
        int cnt = 0;
        String s = br.readLine();
        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                cnt++; // 패턴 idx
                if (cnt == n) {
                    cnt--;
                    result++;
                }
                i++; // 문자열 idx
            } else {
                cnt = 0;
            }
        }
        System.out.println(result);
    }
}
