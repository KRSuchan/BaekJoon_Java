package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_18130 {
    //    p_18130 : 여름나기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long min = Long.MAX_VALUE;
        String result = "";
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 손 선풍기 가격
            int K = Integer.parseInt(st.nextToken()); // 추가비용 시간 간격
            int C = Integer.parseInt(st.nextToken()); // 추가비용의 초기값

            long cnt = (Q - 1) / K; // 초기 비용 횟수
            long cost = P + cnt * (cnt + 1) / 2 * C; // 초기 비용
            if (min > cost) { // 최소값 확인
                min = cost;
                result = i + " " + cost;
            }
        }
        System.out.println(result);
    }
}
