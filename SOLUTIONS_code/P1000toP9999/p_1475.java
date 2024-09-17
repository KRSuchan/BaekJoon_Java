package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1475 {
    //    p_1475 : 방번호
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] nums = new int[10];
        for (int i = 0; i < n.length(); i++) {
            nums[n.charAt(i) - '0']++;
        }
        nums[6] = (nums[6] + nums[9] + 1) / 2;
        nums[9] = 0;
        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println(max);
    }
}
