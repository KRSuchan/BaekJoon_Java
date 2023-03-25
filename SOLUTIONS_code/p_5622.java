import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_5622 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int time=0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i)>='A'&&s.charAt(i)<'A'+3) {
        time+=3;
      } else if (s.charAt(i)>='D'&&s.charAt(i)<'D'+3) {
        time+=4;
      } else if (s.charAt(i)>='G'&&s.charAt(i)<'G'+3) {
        time+=5;
      }else if (s.charAt(i)>='J'&&s.charAt(i)<'J'+3) {
        time+=6;
      }else if (s.charAt(i)>='M'&&s.charAt(i)<'M'+3) {
        time+=7;
      }else if (s.charAt(i)>='P'&&s.charAt(i)<'P'+4) {
        time+=8;
      }else if (s.charAt(i)>='T'&&s.charAt(i)<'T'+3) {
        time+=9;
      }else if (s.charAt(i)>='W'&&s.charAt(i)<'W'+4) {
        time+=10;
      }
    }
    bw.write(time+"");
    bw.flush();
    bw.close();
    br.close();
  }
}