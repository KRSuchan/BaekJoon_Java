package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14503 {
    //    p_14503 : 로봇 청소기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); // 북 : 0, 동 : 1, 남 : 2, 서 : 3
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true) {
            // op1: 해당 칸이 청소 되지 않은 경우 청소. 청소된 빈칸 -> 2로 처리, cnt++
            if (map[r][c] == 0) {
                map[r][c] = 2;
                cnt++;
            }
            // op2: 주변 4칸 중 청소 되지 않은 빈칸이 없는 경우
            if (map[r + 1][c] != 0 && map[r - 1][c] != 0 && map[r][c + 1] != 0 && map[r][c - 1] != 0) {
                // 방향 유지 + 후진 가능하면 한칸 후진 후 op1으로 돌아간다.
                switch (s) {
                    case 0 -> r++;
                    case 1 -> c--;
                    case 2 -> r--;
                    case 3 -> c++;
                }
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (map[r][c] == 1) {
                    break;
                }
                continue;
            }
            // op3: 주변 4칸 중 청소 되지 않은 빈칸이 있는 경우
            s = --s < 0 ? s + 4 : s;// 반시계 방향으로 90도 회전한다.
            int cr = r; // 이동 전 위치 저장
            int cc = c;
            switch (s) { // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                case 0 -> r--;
                case 1 -> c++;
                case 2 -> r++;
                case 3 -> c--;
            }
            if (map[r][c] != 0) { // 청소되지 않은 빈 칸이 아닌 경우
                r = cr;
                c = cc;
            }
        }
        System.out.println(cnt);
    }
}
