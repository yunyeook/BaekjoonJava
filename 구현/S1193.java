package BaekjoonJava.구현;

import java.io.*;
import java.util.StringTokenizer;

public class S1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int curnum = 1;
        int x = 1;
        int y = 1;
        int d = 0; //0 : 우상향, 1:좌하향
        while (curnum != n) {
            if (d == 0) {
                x--;
                y++;
                curnum++;
                if (x == 0) {
                    x++;
                    d = 1;
                }
            } else {
                x++;
                y--;
                curnum++;
                if (y == 0) {
                    y++;
                    d = 0;
                }
            }
        }
        bw.write(String.format("%d/%d", x, y));
        bw.flush();
    }
}
