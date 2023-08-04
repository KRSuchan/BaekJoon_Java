package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.StringTokenizer;

public class p_10250 {
    public void solution() throws IOException {
        // INITIALIZE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        StringTokenizer st;
        int times = 0;
        int height = 0;
        int width = 0;
        int guestNum = 0;
        int floor =0;
        int room = 0;
        String roomNum = "";

        // START TO GET
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        times = Integer.parseInt(st.nextToken());

        for (int i = 0; i < times; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            guestNum = Integer.parseInt(st.nextToken());

            // 층수와 방수 계산
            floor = guestNum%height;
            room = guestNum/height;

            // 층수가 0층 처리
            if (floor == 0) {
                floor = height;
            }else {
                room++;
            }

            if (room<10){
                roomNum = floor+"0"+room;
            }else {
                roomNum = floor + "" + room;
            }
            bw.write(roomNum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
