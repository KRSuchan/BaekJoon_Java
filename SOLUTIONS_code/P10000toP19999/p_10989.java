package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.Arrays;

public class p_10989 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] array = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        for (int i = 0; i < cnt; i++) {
            bw.write(array[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
