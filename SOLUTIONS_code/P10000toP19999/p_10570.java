package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10570 {
    //    p_10570 : Favorite Number
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int[] arr = new int[1001];
            int V = Integer.parseInt(br.readLine());
            while (V-- > 0) {
                int val = Integer.parseInt(br.readLine());
                arr[val]++;
            }
            int max = 0;
            int val = -1;
            for (int i = 0; i < 1001; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    val = i;
                }
            }
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}
