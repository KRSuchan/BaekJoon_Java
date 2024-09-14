package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_27962 {
    //    p_27962 : 오렌지먹은지오랜지
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            String pre = s.substring(0, i);
            String post = s.substring(N - i, N);
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (pre.charAt(j) != post.charAt(j)) {
                    cnt++;
                    if (1 < cnt) break;
                }
            }
            if (cnt == 1) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
