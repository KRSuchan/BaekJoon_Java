package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_2444 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int n = Integer.parseInt(s);
    for (int i = 1; i < n+1; i++) {
      for (int j = n-i; j > 0; j--) {
        bw.write(" ");
      }
      for (int j = 0; j < 2*i-1; j++) {
        bw.write("*");
      }
      bw.write("\n");
    }
    for (int i = n-1; i > 0; i--) {
      for (int j = n-i; j > 0; j--) {
        bw.write(" ");
      }
      for (int j = 0; j < 2*i-1; j++) {
        bw.write("*");
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }  
}