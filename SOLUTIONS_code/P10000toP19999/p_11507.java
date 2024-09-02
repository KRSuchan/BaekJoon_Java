package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_11507 {
    //    p_11507 : 카드셋트
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        boolean[][] cards = new boolean[4][13];
        int[] cnt = new int[4];
        boolean isGreska = false;
        for (int i = 0, len = S.length(); i < len; i += 3) {
            char c = S.charAt(i);
            int n = Integer.parseInt(S.substring(i + 1, i + 3)) - 1;
            int idx = -1;
            switch (c) {
                case 'P' -> idx = 0;
                case 'K' -> idx = 1;
                case 'H' -> idx = 2;
                case 'T' -> idx = 3;
            }
            if (cards[idx][n]) {
                sb.append("GRESKA");
                isGreska = true;
                break;
            }
            cards[idx][n] = true;
            cnt[idx]++;
        }
        if (!isGreska) {
            for (int x : cnt) sb.append(13 - x).append(" ");
        }
        System.out.print(sb);
    }
}
