package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_2798 {
    public void solution() throws IOException {
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
        for (int i = 0; i < cardCnt; i++) {
            sum = cards[i];
            if(sum>limit) continue;
            for (int j = i+1; j < cardCnt; j++) {
                sum = cards[i]+cards[j];
                if (sum>limit) continue;
                for (int k = j+1; k < cardCnt; k++) {
                    sum=cards[i]+cards[j]+cards[k];
                    if (sum>limit) continue;
                    if (sum==limit) {
                        max = sum;
                        break;
                    }else if (sum>max) max=sum;
                }
                if (max==limit) break;
            }
            if (max==limit) break;
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
