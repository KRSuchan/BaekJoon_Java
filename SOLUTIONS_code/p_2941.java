import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_2941 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int s_len = s.length();
    int cnt = 0;
    for (int i = 0; i < s_len; i++) {
      if (i==s_len-1) {
        cnt++;
        break;
      } else if ((s.charAt(i)=='c'&&(s.charAt(i+1)=='='||s.charAt(i+1)=='-'))||
                (s.charAt(i)=='d'&&s.charAt(i+1)=='-')||
                (s.charAt(i)=='l'&&s.charAt(i+1)=='j')||
                (s.charAt(i)=='n'&&s.charAt(i+1)=='j')||
                (s.charAt(i)=='s'&&s.charAt(i+1)=='=')||
                (s.charAt(i)=='z'&&s.charAt(i+1)=='=')) {
        cnt++;
        i++;
        continue;
      } else if(i!=s_len-2&&(s.charAt(i)=='d'&&s.charAt(i+1)=='z'&&s.charAt(i+2)=='=')){
        cnt++;
        i+=2;
        continue;
      } else{
        cnt++;
        continue;
      }
    }
    bw.write(cnt+"");
    bw.flush();
    bw.close();
    br.close();
  }  
}