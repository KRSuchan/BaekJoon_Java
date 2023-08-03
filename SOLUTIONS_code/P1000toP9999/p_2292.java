package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p_2292 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int spot = Integer.parseInt(br.readLine());
    int floor;
    int end = 1;
    for (floor = 1; !(spot <= end); floor++) {
      end += 6*floor;
    }
    bw.write(floor+"");
    bw.flush();
    bw.close();
    br.close();
  }
}
