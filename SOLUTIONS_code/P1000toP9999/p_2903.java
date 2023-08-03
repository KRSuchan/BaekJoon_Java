package SOLUTIONS_code.P1000toP9999;

import java.util.Scanner;

public class p_2903 {

  public void solution() {
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    int wallDots = 2;
    int totalDots = 0;
    for (int i = 0; i < times; i++) {
      wallDots += Math.pow(2, i);
      System.out.println(wallDots);
    }
    totalDots = wallDots * wallDots;
    System.out.println(totalDots);
  }
}
