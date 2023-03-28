import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_10988 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int s_len = s.length();
    short isPalin=1;
    for (int i = 0, j = s_len-1; i==j || i<j ; i++, j--) {
      if (s.charAt(i)==s.charAt(j)) {
        continue;
      }else{
        isPalin=0;
        break;
      }
    }
    bw.write(isPalin+"");
    bw.flush();
    bw.close();
    br.close();
  }
}
