package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_25206 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    StringTokenizer st;
    String /*subj_name,*/ score;
    double cred, total_score=0, average=0,total_cred=0;
    for (int i = 0; i < 20; i++) {
      s = br.readLine();
      st = new StringTokenizer(s," ");
      // subj_name=st.nextToken();
      cred=Double.parseDouble(st.nextToken());
      score=st.nextToken();
      switch (score) {
        case "A+":
          total_score+=cred*4.5;
          total_cred+=cred;
          break;
        case "A0":
          total_score+=cred*4.0;
          total_cred+=cred;
          break;
        case "B+":
          total_score+=cred*3.5;
          total_cred+=cred;
          break;
        case "B0":
          total_score+=cred*3.0;
          total_cred+=cred;
          break;
        case "C+":
          total_score+=cred*2.5;
          total_cred+=cred;
          break;
        case "C0":
          total_score+=cred*2.0;
          total_cred+=cred;
          break;
        case "D+":
          total_score+=cred*1.5;
          total_cred+=cred;
          break;
        case "D0":
          total_score+=cred*1.0;
          total_cred+=cred;
          break;
        case "F":
          total_score+=cred*0.0;
          total_cred+=cred;
          break;
        case "P":
          break;
        default:
          System.out.println("error");
          break;
      }
    }
    average=total_score/total_cred;
    bw.write(average+"");
    bw.flush();
    bw.close();
    br.close();
  }  
}