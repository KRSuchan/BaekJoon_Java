package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_10813 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");

    int[] baskets = new int[Integer.parseInt(st.nextToken())];
    int times = Integer.parseInt(st.nextToken());
    int temp;
    for (int i = 0; i < baskets.length; i++) {
      baskets[i]=i+1;
    }
    int basket_num_1, basket_num_2;
    for (int i = 0; i < times; i++) {
      s = br.readLine();
      st = new StringTokenizer(s, " ");
      basket_num_1=Integer.parseInt(st.nextToken())-1;
      basket_num_2=Integer.parseInt(st.nextToken())-1;
      // swap
      temp = baskets[basket_num_1];
      baskets[basket_num_1]= baskets[basket_num_2];
      baskets[basket_num_2]=temp;
    }

    for (int i = 0; i < baskets.length; i++) {
      bw.write(baskets[i]+" ");
    }
    bw.flush();

    bw.close();
    br.close();
  }
}
