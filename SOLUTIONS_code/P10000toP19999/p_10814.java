package SOLUTIONS_code.P10000toP19999;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p_10814 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int memberCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 나이, 이름을 가진 Member 객체 생성
        Member[] members = new Member[memberCnt];

        for (int i = 0; i < memberCnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
            members[i] = member;
        }

        // 멤버 정렬
        Arrays.sort(members, new Comparator<Member>() {
            // 비교 방법 : 멤버의 나이순
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for (int i = 0; i < memberCnt; i++) {
            bw.write(members[i].getAge()+" "+members[i].getName()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Member {
    private int age;
    private String name;
    public Member(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}