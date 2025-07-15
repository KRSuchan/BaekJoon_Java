package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p_1235 {
    //    p_1235 : 학생 번호
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 학생 수
        String[] nums = new String[N];
        for (int i = 0; i < N; i++)
            nums[i] = br.readLine();

        int len = nums[0].length();
        for (int i = 1; i <= len; i++) {
            HashSet<String> set = new HashSet<>();
            for (String num : nums) set.add(num.substring(len - i));
            if (set.size() == N) {
                System.out.println(i);
                return;
            }
        }
    }
}
