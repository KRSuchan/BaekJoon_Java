package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p_2675 {
  public void solution() throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    int repeat=0;
    String input;
    int input_length;
    for (int i = 0; i < times; i++) {
      repeat = scan.nextInt();
      input=scan.next();
      input_length= input.length();
      char x;
      for (int j = 0; j < input_length; j++) {
        x=input.charAt(j);
        for (int k = 0; k < repeat; k++) {
          bw.write(x);
        }
      }
      bw.write('\n');
      bw.flush();
    }

    bw.close();
    scan.close();
  }
}
