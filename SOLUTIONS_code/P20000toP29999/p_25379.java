package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_25379 {
    //    p_25379 : 피하자
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long cntL = 0;
        long cntR = 0;
        long sum = 0; // idx++들의 합인데 짝수들이 옮겨졌을 경우를 가정했을 때 그만큼 덜 옮겨도 됨.
        int idx = 0; // 옮겨진 짝수들의 갯수-1
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            // 짝수인가?
            if (val % 2 == 0) {
                // 왼쪽 이동 혹은 오른쪽 이동
                sum += idx++;
                cntL += i;
                cntR += N - 1 - i;
            }
        }
        System.out.println(Math.min(cntL, cntR) - sum);
    }
}
