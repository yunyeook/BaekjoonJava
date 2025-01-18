package BaekjoonJava.순열과조합;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        Integer n = Integer.parseInt(st.nextToken());
        Integer r = Integer.parseInt(st.nextToken());
        Integer r2 = n - r;
        r = Math.min(r, r2);
        BigInteger result = BigInteger.valueOf(1);
        for (long i = 1; i <= r; i++) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        for (long i = r; i >= 1; i--) {
            result = result.divide(BigInteger.valueOf(i));
        }


        bw.write(String.valueOf(result));
        bw.flush();

    }
}
