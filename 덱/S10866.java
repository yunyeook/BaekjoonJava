package BaekjoonJava.덱;

import java.util.*;
import java.io.*;

//String.format()이 시간이 오래걸린다!! -> 그냥 append()로 하기

public class S10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        //   LinkedList<Integer> deque = new LinkedList<>(); -> 가능함.

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            StringTokenizer order = new StringTokenizer((br.readLine()));
            String or = order.nextToken();
            if (or.equals("push_front")) {
                deque.addFirst(Integer.parseInt(order.nextToken()));
            } else if (or.equals("push_back")) {
                deque.addLast(Integer.parseInt(order.nextToken()));
            } else if (or.equals("pop_front")) {
                if (deque.isEmpty()) {
                    result.append("-1").append("\n");
                } else {
                    result.append(deque.pollFirst()).append("\n");

                }
            } else if (or.equals("pop_back")) {
                if (deque.isEmpty()) {
                    result.append("-1").append("\n");
                } else {
                    result.append(deque.pollLast()).append("\n");
                }
            } else if (or.equals("size")) {
                result.append(deque.size()).append("\n");
            } else if (or.equals("empty")) {
                if (deque.isEmpty()) {
                    result.append("1").append("\n");
                } else {
                    result.append("0").append("\n");
                }

            } else if (or.equals("front")) {
                if (deque.isEmpty()) {
                    result.append("-1").append("\n");
                } else {
                    result.append(deque.peekFirst()).append("\n");
                }

            } else if (or.equals("back")) {
                if (deque.isEmpty()) {
                    result.append("-1").append("\n");
                } else {
                    result.append(deque.peekLast()).append("\n");
                }

            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

}
