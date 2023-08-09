package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.StringTokenizer;

public class p_11050 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int denom = 1;
        int numer = 1;
        for (int i = 0; i < num2; i++) {
            denom *= num1-i;
            numer *= num2-i;
        }
        bw.write(denom/numer +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
