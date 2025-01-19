package BaekjoonJava.구현;

import java.io.*;
import java.util.*;

public class G2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        String[] list = st.nextToken().split("");
        int answer = 0;
        int tmp = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        boolean isPossible = true;
        boolean prevIsclosed = false;
        for (String elm : list) {
            if (elm.equals("(")) {
                stack.add(1);
                tmp *= 2;
                prevIsclosed = false;
            } else if (elm.equals(("["))) {
                stack.add(2);
                tmp *= 3;
                prevIsclosed = false;

            } else if (elm.equals((")"))) {
                if (!stack.isEmpty() && stack.getLast() == 1) {
                    stack.removeLast();
                    if (!prevIsclosed) {
                        answer += tmp;
                    }
                    tmp /= 2;
                    prevIsclosed = true;

                } else {
                    isPossible = false;
                    break;
                }

            } else if (elm.equals(("]"))) {
                if (!stack.isEmpty() && stack.getLast() == 2) {
                    stack.removeLast();
                    if (!prevIsclosed) {
                        answer += tmp;
                    }
                    tmp /= 3;
                    prevIsclosed = true;

                } else {
                    isPossible = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            isPossible = false;
        }
        if (isPossible) {
            bw.write(String.valueOf(answer));
        } else {
            bw.write("0");
        }
        bw.flush();

    }

}

