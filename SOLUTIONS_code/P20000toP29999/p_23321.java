package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_23321 {
    //    p_23321 : 홍익 댄스파티
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String l1 = br.readLine();
        String l2 = br.readLine();
        br.readLine();
        br.readLine();
        br.readLine();
        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        StringBuilder res3 = new StringBuilder();
        StringBuilder res4 = new StringBuilder();
        StringBuilder res5 = new StringBuilder();
        for (int i = 0; i < l1.length(); i++) {
            if (l2.charAt(i) == 'o') { // 도약 준비 -> 도약 중
                res1.append('o');
                res2.append('w');
                res3.append('l');
                res4.append('n');
                res5.append('.');
            } else if (l1.charAt(i) == 'o') { // 도약 중 -> 도약 준비
                res1.append('.');
                res2.append('o');
                res3.append('m');
                res4.append('l');
                res5.append('n');
            } else { // 착석
                res1.append('.');
                res2.append('.');
                res3.append('o');
                res4.append('L');
                res5.append('n');
            }
        }
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }
}
