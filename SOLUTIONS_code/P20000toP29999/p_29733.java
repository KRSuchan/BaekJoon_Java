package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_29733 {
    //    p_29733 : 3차원 지뢰찾기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[R][C][H];
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < R; x++) {
                String s = br.readLine();
                for (int y = 0; y < C; y++) {
                    if (s.charAt(y) == '*') {
                        map[x][y][z] = -1;
                        int[] dx = {0, -1, 1, 0, 0, -1, 1, -1, 1};
                        int[] dy = {0, 0, 0, -1, 1, -1, 1, 1, -1};
                        for (int l = 0; l < 9; l++) {
                            int nx = x + dx[l];
                            int ny = y + dy[l];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                if (map[nx][ny][z] != -1) {
                                    map[nx][ny][z]++;
                                }
                                if (z + 1 < H && map[nx][ny][z + 1] != -1) {
                                    map[nx][ny][z + 1]++;
                                }
                                if (z - 1 >= 0 && map[nx][ny][z - 1] != -1) {
                                    map[nx][ny][z - 1]++;
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    if (map[x][y][z] == -1) {
                        sb.append("*");
                    } else {
                        sb.append(map[x][y][z] % 10);
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
