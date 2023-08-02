package SOLUTIONS_code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_2566 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    StringTokenizer st;
    int[][] mat = new int[9][9];
    int max = -1, row= -1, col =-1;
    for (int i = 0; i < 9; i++) {
      s= br.readLine();
      st = new StringTokenizer(s, " ");
      for (int j = 0; j < 9; j++) {
        mat[i][j] = Integer.parseInt(st.nextToken());
        if (mat[i][j]>max) {
          max = mat[i][j];
          row = i;
          col = j;
        }
      }
    }
    bw.write(max+"\n"+(row+1)+" "+(col+1)+"");
    bw.flush();
    bw.close();
    br.close();
  }
  
}