package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_10812 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int[] baskets = new int[Integer.parseInt(st.nextToken())];
    for (int i = 0; i < baskets.length; i++) {
      baskets[i]=i+1;
    }
    int times=Integer.parseInt(st.nextToken());
    int begin, end, mid;
    int[] temp;
    for (int i = 0; i < times; i++) {
      s = br.readLine();
      st = new StringTokenizer(s, " ");
      begin=Integer.parseInt(st.nextToken())-1;
      end=Integer.parseInt(st.nextToken())-1;
      mid=Integer.parseInt(st.nextToken())-1;
      temp= new int[mid-begin];
      for (int j = 0; j < mid-begin; j++) {
        temp[j]=baskets[begin+j];
      }
      for (int j = 0; j < end-mid+1; j++) {
        baskets[begin+j]=baskets[j+mid];
      }
      for (int j = 0; j < mid-begin; j++) {
        baskets[begin+end-mid+1+j]=temp[j];
      }
    }
    for (int k = 0; k < baskets.length; k++) {
      bw.write(baskets[k]+" ");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
