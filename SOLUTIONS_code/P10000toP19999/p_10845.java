package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.StringTokenizer;

public class p_10845 {
    public int[] queue;
    public int front = 0;
    public int back = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = Integer.parseInt(br.readLine());
        queue = new int[time];
        StringTokenizer st;
        while(time-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push" :
                    push(queue, Integer.parseInt(st.nextToken()));
                    break;
                case "pop"  :
                    bw.write(pop(queue)+"\n");
                    break;
                case "size" :
                    bw.write(size(queue)+"\n");
                    break;
                case "empty":
                    bw.write(empty(queue)+"\n");
                    break;
                case "front":
                    bw.write(front(queue)+"\n");
                    break;
                case "back" :
                    bw.write(back(queue)+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private void push(int[] queue, int value){
        queue[back] = value;
        back++;
    }
    private int pop(int[] queue){
        if (back-front == 0)
            return -1;
        else {
            int value = queue[front];
            front++;
            return value;
        }
    }
    private int size(int[] queue){
        return back-front;
    }
    private int empty(int[] queue){
        if (back-front == 0) return 1;
        else return 0;
    }
    private int front(int[] queue){
        if (back-front == 0) return -1;
        else return queue[front];
    }
    private int back(int[] queue){
        if (back-front==0) return -1;
        else return queue[back-1];
    }
}
