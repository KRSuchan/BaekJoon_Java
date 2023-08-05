import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int cnt = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int number;
    int primeNums = 0;
    for (int i = 0; i < cnt; i++) {
      number = Integer.parseInt(st.nextToken());
      if (isPrimeNum(number)){
        primeNums++;
      }
    }
    bw.write(primeNums+"");
    bw.flush();
    bw.close();
    br.close();
  }
  public static boolean isPrimeNum(int number){
    if (number == 1) return false;
    for (int i = 2; i < number; i++) {
      if (number%i==0) return false;
    }
    return true;
  }
}