package BaekjoonJava.순열과조합;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class S6603 {
    public static StringBuilder result = new StringBuilder();

    public static void combination(String selected, int[] rest, int count) {
        if (count == 6) {
            result.append(selected.trim() + "\n");
            return;
        }
        if (rest.length == 0) {
            return;
        }
//        if (rest.length + count < 6) {
//            return;
//        }
        for (int i = 0; i < rest.length; i++) {
            int[] rest2;
            if (i <= rest.length - 1) {
                combination(selected + " " + String.valueOf(rest[i]), Arrays.copyOfRange(rest, i + 1, rest.length), count + 1);
            } else {
                rest2 = new int[0];
                combination(selected + " " + String.valueOf(rest[i]), rest2, count + 1);


            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer((br.readLine()));
            List<Integer> list = new LinkedList<>();
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n == 0) {
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            combination("", arr, 0);

            result.append("\n");

        }


        bw.write(result.toString().trim());
        bw.flush();

    }

}
