package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_2908 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int[] a = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    int third=0;
    int second =0;
    int first =0;
    for (int i = 0; i < a.length; i++) {
      third=a[i]%10;
      a[i]/=10;
      second=a[i]%10;
      a[i]/=10;
      first=a[i]%10;
      a[i]=first+second*10 + third*100;
    }
    if (a[0]>a[1]) {
      bw.write(a[0]+"");
    }else{
      bw.write(a[1]+"");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
