import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_10811 {
  public void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s= br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int[] baskets = new int[Integer.parseInt(st.nextToken())];
    int times = Integer.parseInt(st.nextToken());
    int swap_start, swap_end, temp;

    //baskets Initialize
    for (int i = 0; i < baskets.length; i++) {
      baskets[i] = i+1;
    }

    for (int i = 0; i < times; i++) {
      s=br.readLine();
      st= new StringTokenizer(s, " ");
      swap_start=Integer.parseInt(st.nextToken())-1;
      swap_end=Integer.parseInt(st.nextToken())-1;
      for (int j = 0; j < (swap_end-swap_start)/2+1; j++) {
        temp= baskets[swap_start+j];
        baskets[swap_start+j]=baskets[swap_end-j];
        baskets[swap_end-j]=temp;
      }
    }
    for (int i = 0; i < baskets.length; i++) {
      bw.write(baskets[i]+" ");
    }
    bw.flush();

    bw.close();
    br.close();
  }
}
