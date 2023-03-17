package SOLUTIONS_code;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_10810 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");

    // Initialize baskets
    int[] baskets = new int[Integer.parseInt(st.nextToken())];
    int times = Integer.parseInt(st.nextToken());
    for (int i = 0; i < baskets.length; i++) {
      baskets[i]=0;
    }

    // Insert balls
    for (int i = 0; i < times; i++) {
      s= br.readLine();
      st= new StringTokenizer(s, " ");
      int basket_num_1 = Integer.parseInt(st.nextToken());
      int basket_num_2 = Integer.parseInt(st.nextToken());
      int ball_num = Integer.parseInt(st.nextToken());
      for (int j = (basket_num_1-1); j < basket_num_2; j++) {
        baskets[j]=ball_num;
      }
    }

    // check baskets
    for (int i = 0; i < baskets.length; i++) {
      bw.write(baskets[i]+" ");
    }
    bw.flush();

    br.close();
    bw.close();
  }
}
