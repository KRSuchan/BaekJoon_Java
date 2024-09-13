package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_7568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        Person[] people = new Person[cnt];
        //사람들에 대한 무게와 키 입력
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 입력한 사람과 입력된 사람들의 무게와 키 비교하여 덩치가 큰 사람의 승수 증가
            for (int j = 0; j < i; j++) {
                if (people[j].weight < people[i].weight
                        && people[j].height < people[i].height)
                    people[j].biggerThanMe++;
                else if (people[i].weight < people[j].weight
                        && people[i].height < people[j].height)
                    people[i].biggerThanMe++;
            }
        }
        // 순위 출력
        for (int i = 0; i < cnt; i++) {
            bw.write(people[i].biggerThanMe + 1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Person {
        public int weight;
        public int height;
        public int biggerThanMe = 0;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
