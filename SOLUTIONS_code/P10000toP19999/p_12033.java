package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_12033 {
    //    p_12033 : 김인천씨의 식료품가게 (Small)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            sb.append("Case #").append(i).append(": ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] items = new int[N * 2];
            boolean[] check = new boolean[N * 2];
            for (int j = 0; j < N * 2; j++) {
                items[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0, cnt = N; j < N * 2 && cnt > 0; j++) {
                if (check[j] || items[j] % 3 != 0) continue;
                check[j] = true;
                int price = items[j] / 3 * 4;
                for (int k = j + 1; k < N * 2; k++) {
                    if (!check[k] && price == items[k]) {
                        check[k] = true;
                        sb.append(items[j]).append(" ");
                        cnt--;
                        break;
                    }
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
