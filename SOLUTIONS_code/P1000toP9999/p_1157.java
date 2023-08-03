package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_1157 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int s_len = s.length();
    int[] alph = new int['z'-'a'+1];
    int alph_len = alph.length;
    for (int i = 0; i < s_len; i++) {
      if(s.charAt(i)>='a'){
        alph[s.charAt(i)-'a']++;
      }else{
        alph[s.charAt(i)-'A']++;
      }
    }
    char max_alph='0';
    int max=0, count=0;
    for (int i = 0; i < alph_len; i++) {
      if(alph[i]>max){
        max_alph=(char) ('A'+ i);
        max=alph[i];
        count=0;
      } else if(alph[i]==max){
        count++;
      }else{
        continue;
      }
    }
    if (count>0) {
      bw.write("?");
    }else {
      bw.write(max_alph+"");
    }
    bw.flush();
    bw.close();
    br.close();
  }  
}