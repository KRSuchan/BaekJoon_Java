package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_1316 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int times=Integer.parseInt(s);
    int cnt = 0;
    boolean[] repeat_alph;
    int alph_len;
    for (int i = 0; i < times; i++) {
      repeat_alph=new boolean['z'-'a'+1];
      s=br.readLine();
      alph_len=s.length();
      for (int j = 0; j < alph_len; j++) {
        if (j==0 && j== alph_len-1) {
          // 첫글자가 곧 마지막 글자인 경우(한 글자인 경우) 반드시 그룹문자
          cnt++;
        } else if(j==0){
          // 첫글자는 반드시 true
          repeat_alph[s.charAt(j)-'a']=true;
        }else if((j==alph_len-1)&&(repeat_alph[s.charAt(j)-'a']==false||s.charAt(j)==s.charAt(j-1))){
          // 마지막 글자이고 (반복 경험이 아니거나 이전 글자와 같으)면 그룹문자 개수++
          cnt++;
        }else if ((s.charAt(j)!=s.charAt(j-1))&&(repeat_alph[s.charAt(j)-'a']==true)) {
          // 이전 글자와 다르고, 해당 글자가 반복 경험이면 break => 그룹문자 아님
          break;
        } else{
          // 위 경우가 모두 통과됐다면 해당 글자에 true;
          repeat_alph[s.charAt(j)-'a']=true;
        }
      }
    }
    bw.write(cnt+"");
    bw.flush();
    bw.close();
    br.close();
  }
  
}