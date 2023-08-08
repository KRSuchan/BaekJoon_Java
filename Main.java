import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int cnt = Integer.parseInt(br.readLine());
    int[] array = new int[cnt];
    for (int i = 0; i < cnt; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(array);
    for (int i = 0; i < cnt; i++) {
      bw.write(array[i]+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}