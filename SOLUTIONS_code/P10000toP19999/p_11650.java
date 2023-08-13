package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p_11650 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int times = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[times][2];
        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < times; i++) {
            bw.write(coordinates[i][0]+" "+coordinates[i][1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
