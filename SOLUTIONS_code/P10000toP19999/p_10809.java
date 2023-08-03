package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p_10809 {
  public void solution() throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int str_len = s.length();
    int times = 'z'-'a'+1;
    int[] alph = new int[times];
    for (int i = 0; i < times; i++) {
      alph[i]=-1;
    }

    for (int i = 0; i < str_len; i++) {
      for (int j = 0; j < times; j++) {
        if ((s.charAt(i) == 'a'+j)&&(alph[j] == -1)) {
          alph[j]=i;
        } 
      }
    }

    for (int i = 0; i < times; i++) {
      bw.write(alph[i]+" ");
    }
    bw.flush();
    
    scan.close();
    bw.close();
  }
}
