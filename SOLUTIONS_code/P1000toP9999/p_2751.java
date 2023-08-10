package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.Arrays;

public class p_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        for (int i = 0; i < len; i++) {
            bw.write(numbers[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
