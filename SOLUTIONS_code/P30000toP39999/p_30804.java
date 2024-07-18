package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_30804 {
    public int count(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i > 0) count++;
        }
        return count;
    }

    // p_30804
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] nn = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            nn[arr[right++]]++;
            while (count(nn) > 2)
                nn[arr[left++]]--;
            max = Math.max(max, right - left);
        }
        System.out.println(max);
    }
}
