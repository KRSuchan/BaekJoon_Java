package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14646 {
    //    p_14646 : 욱제는 결정장애야!!
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0, u = 0; i < n + n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (!arr[x]) {
                u++;
                arr[x] = !arr[x];
            } else {
                u--;
            }
            result = Math.max(u, result);
        }
        System.out.println(result);
    }
}
