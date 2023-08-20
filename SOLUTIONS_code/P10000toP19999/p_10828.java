package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.StringTokenizer;

public class p_10828 {
    public int[] stack;
    public int size = 0;
    public void solution() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int times = Integer.parseInt(br.readLine());
        stack = new int[times];
        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push" :
                    push(stack, Integer.parseInt(st.nextToken()));
                    break;
                case "pop"  :
                    bw.write(pop(stack)+"\n");
                    break;
                case "size" :
                    bw.write(size(stack)+"\n");
                    break;
                case "empty":
                    bw.write(empty(stack)+"\n");
                    break;
                case "top"  :
                    bw.write(top(stack)+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private void push(int[] array, int value){
        stack[size]=value;
        size++;
    }
    private int pop(int[] array){
        if (size == 0)
            return -1;
        else {
            int value = stack[size - 1];
            size--;
            return value;
        }
    }
    private int size(int[] array){
        return size;
    }
    private int empty(int[] array){
        if (size == 0) return 1;
        else return 0;
    }
    private int top(int[] array){
        if (size == 0) return -1;
        else return stack[size-1];
    }
}
