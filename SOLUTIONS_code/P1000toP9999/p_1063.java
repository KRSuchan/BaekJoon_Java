package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1063 {
    //    p_1063 : 킹
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        Pos king = new Pos(kingPos.charAt(1) - '1', kingPos.charAt(0) - 'A');
        Pos stone = new Pos(stonePos.charAt(1) - '1', stonePos.charAt(0) - 'A');
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            // 킹 임시 이동 좌표
            Pos tempKing = move(king.r, king.c, move);
            if (tempKing.r == king.r && tempKing.c == king.c) {
                // 이동했는데 제자리면 스킵
                continue;
            }
            if (tempKing.r == stone.r && tempKing.c == stone.c) {
                // 임시 이동 좌표에 돌이 있으면
                Pos tempStone = move(stone.r, stone.c, move);
                if (tempStone.r == stone.r && tempStone.c == stone.c) {
                    // 이동했는데 제자리면 스킵
                    continue;
                } else { // 킹 이동, 돌 이동
                    stone = tempStone;
                    king = tempKing;
                }
            } else {
                // 임시 이동 좌표에 돌이 없으면 킹만 이동
                king = tempKing;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (king.c + 'A')).append(king.r + 1).append("\n");
        sb.append((char) (stone.c + 'A')).append(stone.r + 1);
        System.out.println(sb);
    }

    static Pos move(int r, int c, String move) {
        Pos temp = new Pos(r, c);
        boolean canRight = c + 1 < 8;
        boolean canLeft = c - 1 >= 0;
        boolean canTop = r + 1 < 8;
        boolean canBottom = r - 1 >= 0;
        if (move.equals("R") && canRight) {
            temp.c++;
        } else if (move.equals("L") && canLeft) {
            temp.c--;
        } else if (move.equals("B") && canBottom) {
            temp.r--;
        } else if (move.equals("T") && canTop) {
            temp.r++;
        } else if (move.equals("RT") && canRight && canTop) {
            temp.c++;
            temp.r++;
        } else if (move.equals("LT") && canLeft && canTop) {
            temp.c--;
            temp.r++;
        } else if (move.equals("RB") && canRight && canBottom) {
            temp.c++;
            temp.r--;
        } else if (move.equals("LB") && canLeft && canBottom) {
            temp.c--;
            temp.r--;
        }
        return temp;
    }

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
