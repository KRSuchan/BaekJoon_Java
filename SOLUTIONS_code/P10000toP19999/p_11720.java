package SOLUTIONS_code.P10000toP19999;

import java.util.Scanner;

public class p_11720 {
  public void solution() {
    Scanner scan = new Scanner(System.in);
    int length=scan.nextInt();
    String s = scan.next();
    int sum=0;

    for (int i = 0; i < length; i++) {
      sum+=s.charAt(i)-'0';
    }

    System.out.println(sum);
    scan.close();
  }
}
