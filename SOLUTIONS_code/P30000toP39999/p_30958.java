package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_30958 {
    //    p_30958 : 서울사이버대학을 다니고
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            int x = s.charAt(i) - 'a';
            if (x >= 0 && x < 26) alphabet[s.charAt(i) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
            }
        }
        System.out.println(max);
    }
}
