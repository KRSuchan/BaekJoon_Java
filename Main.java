import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] nCards = new int[Integer.parseInt(br.readLine())];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < nCards.length; i++) {
      nCards[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nCards);
    System.out.println();
    for (int i : nCards) {
      System.out.print(i+" ");
    }
    int times = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    for (int i = 0; i < times; i++) {
      int num = Integer.parseInt(st.nextToken());
      bw.write(upperBound(nCards, num)-lowerBound(nCards, num)+" ");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  public static int lowerBound(int[] array, int key){
    int low = 0;
    int high = array.length;

    while(low < high){
      int mid = (low + high) / 2;
      if (key<=array[mid]) high = mid;
      else low = mid+1;
    }
    return low;
  }
  public static int upperBound(int[] array, int key){
    int low = 0;
    int high = array.length;

    while(low < high){
      int mid = (low + high) / 2;
      if (key < array[mid]) high = mid;
      else low = mid+1;
    }
    return low;
  }
}