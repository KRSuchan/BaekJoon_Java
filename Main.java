import SOLUTIONS_code.P1000toP9999.*;
import SOLUTIONS_code.P10000toP19999.*;
import SOLUTIONS_code.P20000toP29999.*;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s;
    StringTokenizer st;
    int[] walls;
    while(true){
      s = br.readLine();
      st = new StringTokenizer(s, " ");
      walls = new int[3];
      for (int i = 0; i < 3; i++) {
        walls[i] = Integer.parseInt(st.nextToken());
      }
      // 종료 case
      if (walls[0] == 0 & walls[1] == 0 && walls[2] == 0){
        break;
      }
      if(isRightTriangle(walls) == false) {
        bw.write("wrong\n");
      }else bw.write("right\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  public static boolean isRightTriangle(int[] walls){
    int max =0;
    int sum=0;

    // 한변이라도 0이면 false / 가장 긴 변의 길이, 모든 변의 길이
    for (int i = 0; i < 3; i++) {
      if (walls[i] == 0) return false;
      sum+=walls[i];
      if (walls[i]>max) {
        max = walls[i];
      }
    }

    // 가장 긴 변이 다른 변들의 합보다 크면 false
    if (max >(sum-max)) return false;

    // 짧은 변들의 제곱의 합이 가장 긴 변의 제곱의 합과 같을 때
    sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += walls[i]*walls[i];
    }
    max*=max;
    if (!(max == sum-max)) return false;
    
    // 최종
    return true;
  }

}