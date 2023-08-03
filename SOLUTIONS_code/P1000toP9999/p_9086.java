package SOLUTIONS_code.P1000toP9999;

import java.util.Scanner;

public class p_9086 {
  public void solution() {
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    for (int i = 0; i < times; i++) {
      String str=scan.next(); // nextLine()은 StringIndexOutOfBound 예외 발생
      System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
    }
    scan.close();
  }
}
