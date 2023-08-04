package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_2475 {
    public void solution () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int cnt = 5;
        int number = 0;
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            number = Integer.parseInt(st.nextToken());
            number *=number;
            sum += number;
        }
        sum%=10;
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
