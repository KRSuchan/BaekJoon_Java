import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    int cardCnt = Integer.parseInt(st.nextToken());
    int limit = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    int[] cards = new int[cardCnt];
    int sum = 0;
    int max = 0;
    for (int i = 0; i < cardCnt; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    max = getMax(cards, sum, limit, 3, 1);
    bw.write(max+"");
    bw.flush();
    bw.close();
    br.close();
  }
  public static int getMax(int[] array, int sum, int limit, int goalDepth, int currDepth){
    int max = 0;
    int total = 0;
    int[] newArray = new int[array.length-1];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = array[i];
    }
    for (int i = 0; i < array.length; i++) {
      total=sum+array[i];
      if (total>limit) continue;
      if(goalDepth!=currDepth) {
        max = getMax(newArray, total, limit, goalDepth, currDepth++);
      }
      System.out.println(max);
      if(total>max && total<=limit) max=total;
      if(max == limit) return max;
    }
    return max;
  }
}