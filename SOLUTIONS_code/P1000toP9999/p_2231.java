package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_2231 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getConstructor(Integer.parseInt(br.readLine()))+"");
        bw.flush();
        bw.close();
        br.close();
    }
    public int getConstructor(int number){
        int times = Integer.toString(number).length();
        int start = number-(times*9);
        int sum = 0;
        int num =0;
        for (int i = start; i < number; i++) {
            sum = i;
            num = i;
            while(num != 0){
                sum+=num%10;
                num/=10;
            }
            if (sum == number) return i;
        }
        return 0;
    }
}
