import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_10798 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    int s_len;
    char[][] mat = new char[15][5];

    for (int i = 0; i < 5; i++) {
      s= br.readLine();
      s_len = s.length();
      for (int j = 0; j < 15; j++) {
        if (s_len==j) break;
        mat[j][i] = s.charAt(j);
      }
    }

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        if (mat[i][j]==0) continue;
        bw.write(mat[i][j]+"");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
