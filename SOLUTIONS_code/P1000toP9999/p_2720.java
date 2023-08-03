package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p_2720 {
  public void solution() throws IOException{
    Scanner scan = new Scanner(System.in);
    int time = Integer.parseInt(scan.next());

    for (int i = 0; i < time; i++) {
      OutputCent(Integer.parseInt(scan.next()));
    }
    scan.close();
  }

  private void OutputCent(int cent) throws IOException{
    final int quater = 25;
    final int dime = 10;
    final int nickel = 5;
    final int penny = 1;
    int quaterCnt = 0;
    int dimeCnt = 0;
    int nickelCnt = 0;
    int pennyCnt = 0;
    if (cent>=quater){
      quaterCnt = (cent / quater);
      cent = cent-quaterCnt*quater;
    }
    if(cent>=dime){
      dimeCnt = (cent / dime);
      cent = cent-dimeCnt*dime;
    }
    if(cent>=nickel){
      nickelCnt = (cent / nickel);
      cent = cent-nickelCnt*nickel;
    }
    if(cent>=penny){
      pennyCnt = (cent / penny);
      cent = cent-pennyCnt*penny;
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(quaterCnt+" "+dimeCnt+" "+nickelCnt+" "+pennyCnt+"\n");
    bw.flush();
  }
}