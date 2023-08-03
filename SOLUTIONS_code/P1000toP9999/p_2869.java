package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_2869 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int go = Integer.parseInt(st.nextToken());
        int back = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int now = 0;
        int days = 1;
        while(now+go<goal){
            now+=go-back;
            days++;
        }
        bw.write(days+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
