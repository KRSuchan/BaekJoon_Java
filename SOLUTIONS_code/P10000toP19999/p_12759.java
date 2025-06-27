package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_12759 {
    //    p_12759 : 틱! 택! 토!
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[3][3];
        int winner = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            // 위치에 두기
            map[r][c] = N;
            // 가로 확인
            if (map[r][0] == map[r][1] && map[r][1] == map[r][2]) {
                winner = N;
                break;
            }
            // 세로 확인
            if (map[0][c] == map[1][c] && map[1][c] == map[2][c]) {
                winner = N;
                break;
            }
            if (map[1][1] == N) {
                // 좌상 대각 확인
                if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                    winner = N;
                    break;
                }
                // 우상 대각 확인
                if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                    winner = N;
                    break;
                }
            }
            // 차례 변경
            if (N == 1) N = 2;
            else N = 1;
        }
        System.out.println(winner);
    }
}
