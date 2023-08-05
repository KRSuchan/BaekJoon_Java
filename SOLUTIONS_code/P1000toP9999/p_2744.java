package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_2744 {
    public void soulution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char letter;
        int dif = 'a' - 'A';
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            if (letter<'a')bw.write((char) (letter + dif)+"");
            else bw.write((char) (letter - dif)+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
