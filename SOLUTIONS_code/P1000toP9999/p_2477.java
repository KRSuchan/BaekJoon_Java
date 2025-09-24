package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2477 {
    //    p_2477 : 참외밭
    static final int EAST = 1, WEST = 2, SOUTH = 3, NORTH = 4;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] lens = new int[6];

        int maxWidth = 0;
        int maxHeight = 0;
        int widthIdx = 0;
        int heightIdx = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            lens[i] = Integer.parseInt(st.nextToken());
            if (dir == EAST || dir == WEST) {
                if (lens[i] > maxWidth) {
                    maxWidth = lens[i];
                    widthIdx = i;
                }
            } else {
                if (lens[i] > maxHeight) {
                    maxHeight = lens[i];
                    heightIdx = i;
                }
            }
        }
        
        int innerHeight = lens[(widthIdx + 5) % 6] == maxHeight ? maxHeight - lens[(widthIdx + 1) % 6] : maxHeight - lens[(widthIdx + 5) % 6];
        int innerWidth = lens[(heightIdx + 5) % 6] == maxWidth ? maxWidth - lens[(heightIdx + 1) % 6] : maxWidth - lens[(heightIdx + 5) % 6];

        System.out.println(K * (maxWidth * maxHeight - innerWidth * innerHeight));
    }
}
