package SOLUTIONS_code.P10000toP19999;

import java.io.*;

public class p_10872 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int fac = 1;
        for (int i = 2; i <= num; i++) {
            fac*=i;
        }
        bw.write(fac+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
