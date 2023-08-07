package SOLUTIONS_code.P10000toP19999;

import java.io.*;

public class p_15829 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum=0;
        long pow = 1;
        for (int i = 0; i < times; i++) {
            sum+=(s.charAt(i)-'a'+1)*pow;
            pow = (pow*31) % 1234567891;
        }
        bw.write(sum%1234567891+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
