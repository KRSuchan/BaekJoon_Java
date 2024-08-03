package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_21567 {
    //    p_21567 : 숫자의 개수 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        long abc = Long.parseLong(br.readLine()) * Long.parseLong(br.readLine()) * Long.parseLong(br.readLine());
        String s = Long.toString(abc);
        for (int i = 0; i < s.length(); i++) {
            numbers[s.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : numbers) {
            sb.append(v).append("\n");
        }
        System.out.print(sb);
    }
}
