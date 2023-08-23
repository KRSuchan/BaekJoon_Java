package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_5543 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int hamburger = 0;
        int juice = 0;
        int minH = 2000;
        int minJ = 2000;
        for (int i = 0; i < 3; i++) {
            hamburger = Integer.parseInt(br.readLine());
            if (minH > hamburger) minH = hamburger;
        }
        for (int i = 0; i < 2; i++) {
            juice = Integer.parseInt(br.readLine());
            if (minJ > juice) minJ = juice;
        }
        bw.write(minH+minJ-50+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
