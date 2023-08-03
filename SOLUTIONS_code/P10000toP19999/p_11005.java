package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_11005 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s= br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int num_10 = Integer.parseInt(st.nextToken());
    int jb = Integer.parseInt(st.nextToken());
    int R = 0;
    char alph = 0;
    String num_jb = "";
    while (num_10>0) {
      R = num_10%jb;
      num_10/=jb;
      if (R>9) {
        alph = (char)('A'+R-10);
        num_jb=alph+num_jb;
      }else{
        num_jb=R+num_jb;
      }
    }
    bw.write(num_jb+"");
    bw.flush();
    bw.close();
    br.close();
  }
}
