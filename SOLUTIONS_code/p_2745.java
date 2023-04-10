import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_2745 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    String n = st.nextToken();
    int b = Integer.parseInt(st.nextToken());
    int n_len = n.length();
    int result = 0;
    for (int i = 0; i < n_len; i++) {
      if (n.charAt(n_len-i-1)>='A' && n.charAt(n_len-i-1)<='Z') {
        result += (n.charAt(n_len-i-1)-'A'+10)*Math.pow(b, i);
      } else {
        result += (n.charAt(n_len-i-1)-'0')*Math.pow(b, i);
      }
    }
    bw.write(result+"");
    bw.flush();
    bw.close();
    br.close();
  }  
}