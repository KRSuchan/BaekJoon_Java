package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_2738 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int rows =Integer.parseInt(st.nextToken());
    int cols =Integer.parseInt(st.nextToken());
    int[][] mat_A = new int[rows][cols];
    int[][] mat_B = new int[rows][cols];
    int[][] mat_Rs = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      s=br.readLine();
      st= new StringTokenizer(s, " ");
      for (int j = 0; j < cols; j++) {
        mat_A[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < rows; i++) {
      s=br.readLine();
      st= new StringTokenizer(s, " ");
      for (int j = 0; j < cols; j++) {
        mat_B[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat_Rs[i][j]=mat_A[i][j]+mat_B[i][j];
        bw.write(mat_Rs[i][j]+" ");
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}