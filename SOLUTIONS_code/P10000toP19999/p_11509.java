package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11509 {
    //    p_11509 : 풍선 맞추기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int[] arr = new int[1_000_002];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (arr[x + 1] > 0) {
                arr[x + 1]--;
            }
            arr[x]++;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = arr[i] > 0 ? res + arr[i] : res;
        }
        System.out.println(res);
    }
}
