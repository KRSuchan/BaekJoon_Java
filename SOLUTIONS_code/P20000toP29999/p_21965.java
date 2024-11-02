package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_21965 {
    //    p_21965 : 드높은 남산 위에 우뚝 선
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        boolean visited = false;
        boolean res = true;
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            boolean up = prev < cur && !visited;
            boolean down = prev > cur && visited;
            if (prev > cur && !visited) {
                visited = true;
            } else if (!up && !down) {
                res = false;
                break;
            }
            prev = cur;
        }
        System.out.println(res ? "YES" : "NO");
    }
}
