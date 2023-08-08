package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_2775 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        int[][] rooms = new int[15][15];
        int floor = 0;
        int room = 0;
        for (int i = 0; i < 15; i++) {
            rooms[i][1] = 1;
            rooms[i][0] = 0;
            rooms[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                rooms[i][j] = rooms[i-1][j]+rooms[i][j-1];
            }
        }
        for (int i = 0; i < cases; i++) {
            floor = Integer.parseInt(br.readLine());
            room = Integer.parseInt(br.readLine());
            bw.write(rooms[floor][room]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
