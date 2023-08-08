package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_2609 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int temp = 0;
        if (num1 < num2){
            temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int gcd = 1;
        int lcm = 1;
        int divisor;
        while(true){
            divisor = getDivisor(num1, num2);
            if(divisor!=0){
                gcd *= divisor;
                lcm *= divisor;
                num1 /= divisor;
                num2 /= divisor;
            }else {
                lcm *= num1 * num2;
                break;
            }
        }
        bw.write(gcd+"\n"+lcm+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public int getDivisor(int num1, int num2){
        for (int divisor = num2; divisor > 1; divisor--) {
            if (num2 % divisor == 0 && num1 % divisor == 0) {
                return divisor;
            }
        }
        return 0;
    }
}
