package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1069 {
    //    p_1069 : 집으로
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double walk = Math.sqrt(X * X + Y * Y); // 걸어간 시간
        if (D < T) {
            System.out.println(walk);
            return;
        }

        int jumpCnt = (int) (walk / D); // 점프 횟수

        double jump = walk - D * jumpCnt + T * jumpCnt;
        double oneMoreJump = D * (jumpCnt + 1) - walk + T * (jumpCnt + 1);
        // min(걸어간 시간, 점프 한번더 + 걸어가기, 점프 수 + 걸어가기)
        double result = Math.min(walk, Math.min(jump, oneMoreJump));

        if (jumpCnt > 0)  // 다른 방향으로 이동하고 목적지로 다시 점프
            result = Math.min(result, (jumpCnt + 1) * T);
        else if (walk < D)  // 다른 방향으로 점프하고 목적지로 다시 점프
            result = Math.min(result, T * 2);

        System.out.println(result);
    }
}
