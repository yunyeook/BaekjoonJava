import java.util.*;
import java.io.*;

public class S17413 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        StringBuffer result = new StringBuffer();
        StringBuilder strg = new StringBuilder();
        StringBuilder strr = new StringBuilder();
        String str = st.toString();
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            System.out.println(s);
            if (s.equals("<") || strg.length() > 0) {
                if (s.equals("<")) {
                    strg.append(s);

                    if (strr.length() > 0) {
                        result.append(strr.reverse());
                        strr = new StringBuilder();
                    }

                } else if (s.equals(">")) {
                    strg.append(s);
                    result.append(strg);
                    strg = new StringBuilder();
                } else {
                    strg.append(s);
                }
            } else {
                if (s.equals(" ")) {
                    result.append(" ");
                } else {
                    strr.append(s);
                }
            }
        }
        bw.write(result.toString());
        bw.flush();
    }
}