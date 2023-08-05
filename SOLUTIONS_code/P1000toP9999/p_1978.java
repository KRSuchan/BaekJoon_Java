package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1978 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int number = 0;
        int primeNums = 0;
        for (int i = 0; i < cnt; i++) {
            number = Integer.parseInt(st.nextToken());
            if (isPrimeNum(number)){
                primeNums++;
            }
        }
        bw.write(primeNums+"");
        bw.flush();
        bw.close();
        br.close();
    }
    public boolean isPrimeNum(int number){
        if (number == 1) return false;
        for (int i = 2; i < number; i++) {
            if (number%i==0) return false;
        }
        return true;
    }
}
