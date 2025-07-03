package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14564 {
    //    p_14564 : 두부 게임 (Tofu Game)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int mid = M / 2 + 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int X = Integer.parseInt(br.readLine());
            if (X == mid) {
                sb.append(0).append("\n");
                break;
            }
            int diff = X - mid;
            int next = (A + diff) % N;
            if (next <= 0) next += N;
            sb.append(next).append("\n");
            A = next;
        }
        System.out.println(sb);
    }
}
