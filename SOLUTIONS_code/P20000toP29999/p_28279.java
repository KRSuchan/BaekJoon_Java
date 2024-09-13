package SOLUTIONS_code.P20000toP29999;

import java.io.*;
import java.util.StringTokenizer;

public class p_28279 {
    public void solution() throws IOException {
        DequeApp dequeApp = new DequeApp();
        dequeApp.run();
    }

    static class DequeApp {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        MyDeque<Integer> deque = new MyDeque<>();

        public void run() throws IOException {
            int numIntegers = Integer.parseInt(br.readLine());
            while (numIntegers > 0) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                execute(cmd);
                numIntegers--;
            }
            br.close();
            bw.flush();
            bw.close();
        }

        /**
         * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
         * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
         * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
         * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
         * 5: 덱에 들어있는 정수의 개수를 출력한다.
         * 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
         * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
         * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
         */
        public void execute(int cmd) throws IOException {
            if (cmd == 1)
                deque.addFirst(Integer.parseInt(st.nextToken()));
            else if (cmd == 2)
                deque.addLast(Integer.parseInt(st.nextToken()));
            else if (cmd == 3)
                bw.write((deque.first() != null ? deque.removeFirst() : -1) + "\n");
            else if (cmd == 4)
                bw.write((deque.last() != null ? deque.removeLast() : -1) + "\n");
            else if (cmd == 5)
                bw.write(deque.size() + "\n");
            else if (cmd == 6)
                bw.write((deque.isEmpty() ? 1 : 0) + "\n");
            else if (cmd == 7)
                bw.write((!deque.isEmpty() ? deque.first() : -1) + "\n");
            else if (cmd == 8)
                bw.write((!deque.isEmpty() ? deque.last() : -1) + "\n");
            else // wrong number
                System.out.printf("Wrong Number : %d\n", cmd);
        }

        static class MyDeque<E extends Comparable<E>> {
            private Node<E> rear;
            private Node<E> front;
            private int numItems = 0;

            public MyDeque() {
                /**
                 * front와 rear를 dummyNode로
                 */
                front = new Node<>(null);
                rear = new Node<>(null);
                front.setNext(rear);
                rear.setPrev(front);
            }

            public int size() {
                return numItems;
            }

            public boolean isEmpty() {
                return numItems == 0;
            }

            public E first() {
                return front.getNext().getItem();
            }

            public E last() {
                return rear.getPrev().getItem();
            }

            public void addFirst(E obj) {
                Node<E> newNode = new Node<>(obj);
                Node<E> successor = front.getNext();
                newNode.setPrev(front);
                newNode.setNext(successor);
                front.setNext(newNode);
                successor.setPrev(newNode);
                numItems++;
            }

            public void addLast(E obj) {
                Node<E> newNode = new Node<>(obj);
                Node<E> predecessor = rear.getPrev();
                newNode.setPrev(predecessor);
                newNode.setNext(rear);
                predecessor.setNext(newNode);
                rear.setPrev(newNode);
                numItems++;
            }

            public E removeFirst() {
                if (numItems == 0) // if target is rear(dummy), then successor is null;
                    return null;
                Node<E> target = front.getNext();
                Node<E> successor = target.getNext();
                front.setNext(successor);
                successor.setPrev(front);
                numItems--;
                return target.getItem();
            }

            public E removeLast() {
                if (numItems == 0) // if target is front(dummy), then predecessor is null;
                    return null;
                Node<E> target = rear.getPrev();
                Node<E> predecessor = target.getPrev();
                rear.setPrev(predecessor);
                predecessor.setNext(rear);
                numItems--;
                return target.getItem();
            }

            /**
             * protected embedded: 접근 제한, 상속 가능
             * static : 여러 instance가 만들어져도 Node는 한 번만 만들어져 공유됨.
             */
            protected static class Node<E extends Comparable<E>> {
                private E item;
                private Node<E> next;
                private Node<E> prev;

                public Node(E item) {
                    this.item = item;
                    this.next = null;
                    this.prev = null;
                }

                public Node(E item, Node<E> next, Node<E> prev) {
                    this.item = item;
                    this.next = next;
                    this.prev = prev;
                }

                public E getItem() {
                    return item;
                }

                public void setItem(E item) {
                    this.item = item;
                }

                public Node<E> getNext() {
                    return next;
                }

                public void setNext(Node<E> next) {
                    this.next = next;
                }

                public Node<E> getPrev() {
                    return prev;
                }

                public void setPrev(Node<E> prev) {
                    this.prev = prev;
                }
            }
        }

    }
}

