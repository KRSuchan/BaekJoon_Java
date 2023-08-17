package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sugar = Integer.parseInt(br.readLine());
        bw.write(getMinBags(sugar, 3, 5)+"");
        bw.close();
        br.close();
    }
    public static int getMinBags(int total, int bag1, int bag2){
        int min = total/bag1+1;
        for (int i = 0; i <= total/bag1; i++) {
            if (total-(bag1*i) == 0 && i < min) min = i;
            else {
                for (int j = 1; j <= (total - (bag1 * i)) / bag2; j++) {
                    if ((total - (bag1 * i)) - (bag2 * j) == 0 && i + j < min) min = i + j;
                }
            }
        }
        if (min > total/bag1) return -1;
        else return min;
    }
}
