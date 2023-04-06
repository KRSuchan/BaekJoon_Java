import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_2563 {
  public void solution() throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   String s= br.readLine();
   StringTokenizer st = new StringTokenizer(s, " ");
   int times = Integer.parseInt(s);
   int x=0, y=0, result =0;;
   boolean[][] mat = new boolean[100][100];

   for (int i = 0; i < times; i++) {
    s=br.readLine();
    st=new StringTokenizer(s, " ");
    x=Integer.parseInt(st.nextToken())-1;
    y=Integer.parseInt(st.nextToken())-1;
    for (int j = 0; j < 10; j++) {
      for (int j2 = 0; j2 < 10; j2++) {
        mat[j+x][j2+y]=true;
      }
    }
   }
   for (int i = 0; i < 100; i++) {
    for (int j = 0; j < 100; j++) {
      if (mat[i][j]==true) {
        result++;
      } else {
        continue;
      }
    }
   }
   bw.write(result+"");
   bw.flush();
   bw.close();
   br.close();
  }
}