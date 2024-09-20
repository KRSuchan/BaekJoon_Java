package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_14381 {
    //    p_14381 : 숫자세는 양 (Small)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            sb.append("Case #").append(i).append(": ");

            int N = Integer.parseInt(br.readLine());
            boolean[] nums = new boolean[10];
            if (N == 0) {
                sb.append("INSOMNIA");
            } else {
                int idx = 1;
                int res = 0;
                while (hasZero(nums)) {
                    int x = N * idx;
                    res = x;
                    while (x != 0) {
                        nums[x % 10] = true;
                        x /= 10;
                    }
                    idx++;
                }
                sb.append(res);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean hasZero(boolean[] nums) {
        for (boolean num : nums) {
            if (!num) {
                return true;
            }
        }
        return false;
    }
}
