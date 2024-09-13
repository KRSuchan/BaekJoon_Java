package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1966 {
    private static int getCntPrint(Queue<Doc> queue) {
        if (queue.size() == 1) return 0;
        int i = 0;
        while (true) {
            Queue<Doc> tempQueue = new LinkedList<>();
            tempQueue.addAll(queue);
            Doc tempDoc = tempQueue.poll();
            while (hasMoreImportant(tempQueue, tempDoc.importance)) {
                //  이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
                queue.offer(queue.poll());
                tempQueue = new LinkedList<>();
                tempQueue.addAll(queue);
                tempDoc = tempQueue.poll();
            } // 그렇지 않다면 바로 인쇄를 한다.
            if (queue.poll().isWondered) return i;
            i++;
        }
    }

    private static boolean hasMoreImportant(Queue<Doc> queue, int importance) {
        // 조건 1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
        while (!queue.isEmpty()) {
            // 조건 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면
            if (importance < queue.poll().importance) return true;
        }
        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (times-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int docCnt = Integer.parseInt(st.nextToken());
            int docPos = Integer.parseInt(st.nextToken());
            Queue<Doc> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            // Document 객체에 importance 와 isWondered 값 부여
            for (int i = 0; i < docCnt; i++) {
                Doc document;
                if (i == docPos) {
                    document = new Doc(Integer.parseInt(st.nextToken()), true);
                } else {
                    document = new Doc(Integer.parseInt(st.nextToken()));
                }
                queue.offer(document);
            }
            bw.write(getCntPrint(queue) + 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Doc {
        public int importance;
        public boolean isWondered = false;

        Doc(int importance, boolean isWondered) {
            this.importance = importance;
            this.isWondered = isWondered;
        }

        Doc(int importance) {
            this.importance = importance;
        }
    }
}
