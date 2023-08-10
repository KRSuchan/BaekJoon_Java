package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_1676 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        int cnt_two = 0;
        int cnt_five = 0;
        int cnt_zero = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 5 == 0) cnt_five += cntDivisor(i, 5);
            if (i % 2 == 0) cnt_two += cntDivisor(i, 2);
        }
        if (cnt_five>cnt_two) cnt_zero+=cnt_two;
        else cnt_zero+=cnt_five;

        bw.write(cnt_zero+"");
        bw.flush();
        bw.close();
        br.close();
    }
    public int cntDivisor(int number, int divisor){
        int cnt = 0;
        while(number % divisor == 0){
            cnt++;
            number /= divisor;
        }
        return cnt;
    }
}
