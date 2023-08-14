package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.StringTokenizer;

public class p_11866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        int killer = Integer.parseInt(st.nextToken());
        boolean[] isAlive = new boolean[cnt];
        int cur;
        int j =0;
        int[] result = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            isAlive[i] = true;
        }
        for (int i = 0; i < cnt; i++) {
            cur=1;
            while(true) {
                if (j == cnt) j=0;
                if (isAlive[j] && cur == killer) {
                    isAlive[j] = false;
                    result[i] = j+1;
                    break;
                } else if (isAlive[j]) {
                    cur++;
                    j++;
                } else if (!isAlive[j]){
                    j++;
                }
                else {
                    j++;
                    cur++;
                }
            }
        }
        bw.write("<");
        for (int i = 0; i < cnt-1; i++) {
            bw.write(result[i]+", ");
        }
        bw.write(result[cnt-1]+">");
        bw.flush();
        bw.close();
        br.close();
    }
}
