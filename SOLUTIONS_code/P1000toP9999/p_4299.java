package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_4299 {
    //    p_4299 : AFC 윔블던
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        boolean isExist = false;
        int res1 = -1;
        int res2 = -1;
        for (int i = sum / 2, j = sum - i; i >= 0; i--, j++) {
            if (Math.abs(i - j) == diff) {
                res1 = Math.max(i, j);
                res2 = Math.min(i, j);
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.printf("%d %d", res1, res2);
        } else {
            System.out.println(-1);
        }
    }
}
