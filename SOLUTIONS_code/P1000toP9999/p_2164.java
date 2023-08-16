package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p_2164 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= times; i++) {
            queue.offer(i);
        }
        while (queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());
        }
        bw.write(queue.poll()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
