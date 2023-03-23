import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_1152 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s= br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int words=st.countTokens();
    bw.write(words+"");
    bw.flush();
    bw.close();
    br.close();
  }
}
