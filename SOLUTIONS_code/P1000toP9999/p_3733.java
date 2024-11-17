package SOLUTIONS_code.P1000toP9999;

import java.io.IOException;
import java.util.Scanner;

public class p_3733 {
    //    p_3733 : Shares
    public static void solution(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n, s;
        while (sc.hasNext()) {
            n = sc.nextInt();
            s = sc.nextInt();
            System.out.println(s / (n + 1));
        }
    }
}
