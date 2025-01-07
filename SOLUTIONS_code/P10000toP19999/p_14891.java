package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14891 {
    //    p_14891 : 톱니바퀴
    static int[][] gear;
    static int[] dir;
    static int score = 0;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0'; // N극:0, S극:1
            }
        }
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int turn = Integer.parseInt(st.nextToken());
            dir = new int[4];
            dir[num] = turn;
            checkDir(num);
            rotate();
        }
        score();
        System.out.println(score);
    }

    private static void checkDir(int num) {
        for (int i = num; i > 0; i--) { // 좌측 기어
            if (gear[i - 1][2] != gear[i][6]) {
                dir[i - 1] = -dir[i];
            } else {
                break;
            }
        }
        for (int i = num; i < 3; i++) { // 우측 기어
            if (gear[i + 1][6] != gear[i][2]) {
                dir[i + 1] = -dir[i];
            } else {
                break;
            }
        }
    }

    private static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) {
                int temp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = temp;
            }
            if (dir[i] == -1) {
                int temp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = temp;
            }
        }
    }

    private static void score() {
        if (gear[0][0] == 1) score += 1;
        if (gear[1][0] == 1) score += 2;
        if (gear[2][0] == 1) score += 4;
        if (gear[3][0] == 1) score += 8;
    }
}
