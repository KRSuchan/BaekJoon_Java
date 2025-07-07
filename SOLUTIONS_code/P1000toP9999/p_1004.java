package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1004 {
    //    p_1004 : 어린 왕자
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int planets = Integer.parseInt(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = 0; i < planets; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                int r = Integer.parseInt(st2.nextToken());

                int pr = (int) Math.pow(r, 2);
                // 각 지점과 원 중심의 거리
                int sd = (int) (Math.pow(sx - x, 2) + Math.pow(sy - y, 2));
                int ed = (int) (Math.pow(ex - x, 2) + Math.pow(ey - y, 2));
                // 카운트 하지 않는 경우
                // 1. 출발 지점과 도착 지점이 모두 원 내부에 있다.
                // 2. 출발 지점과 도착 지점이 모두 원 외부에 있다.
                if (sd < pr && ed < pr) continue;
                else if (sd > pr && ed > pr) continue;
                // 그 외의 경우 카운트
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
