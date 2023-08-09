package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int part = Integer.parseInt(br.readLine());
        int times = 1;
        int number = 666;
        // 666의 앞과 뒤 수를 구분해서 속도를 높이는 알고리즘을 생각했지만 코드가 길어지니
        // 가독성이 떨어지지 않을까.. 그치만 주석을 달아놓으면 잘 알 것 같기도 하고..
        while(part != times){
            number++;
            if (Integer.toString(number).contains("666")){
                times++;
            }
        }
        bw.write(number+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
