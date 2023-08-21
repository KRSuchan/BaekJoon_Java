package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.Arrays;

public class p_18110 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        if (times != 0) {
            int trimmed = times * 15 / 100;
            if (times * 15 % 100 >= 50) trimmed++;
            int array[] = new int[times];
            int level = 0;
            for (int i = 0; i < times; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(array);
            for (int i = trimmed; i < times - trimmed; i++) {
                level += array[i];
            }
            times -= trimmed * 2;
            if ((level % times) * 2 >= times) level = (level/times)+1;
            else level/=times;
            bw.write(level + "");
        } else bw.write(0+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
