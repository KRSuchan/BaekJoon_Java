package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_12866 {
    //    p_12866 : 피노키오
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] dna = new int[4];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A' -> dna[0]++;
                case 'C' -> dna[1]++;
                case 'G' -> dna[2]++;
                case 'T' -> dna[3]++;
            }
        }
        long res = 1L;
        for (int i = 0; i < 4; i++) {
            res = (res * dna[i]) % 1_000_000_007;
        }
        System.out.println(res);
    }
}
