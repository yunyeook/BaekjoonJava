package BaekjoonJava.BFS;

import java.util.*;
import java.io.*;

public class S4963 {
    public static void main(String[] args) throws Exception {
        int w = 100;
        int h = 100;
        StringBuffer result = new StringBuffer();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (w != 0 && h != 0) {
            StringTokenizer st = new StringTokenizer((br.readLine()));
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            int[][] arr = new int[h][w];
            for (int x = 0; x < h; x++) {
                StringTokenizer sst = new StringTokenizer((br.readLine()));
                for (int y = 0; y < w; y++) {
                    arr[x][y] = Integer.parseInt(sst.nextToken());
                }
            }
            int landCount = 0;
            Set<Integer> visit = new HashSet<>();
            for (int c = 0; c < w * h; c++) {
                int x = Math.floorDiv(c, w);
                int y = c % w;
                if (visit.contains(c)) {
                    continue;
                } else if (arr[x][y] == 0) {
                    visit.add(x * w + y);
                } else {
                    visit.add(c);
                    landCount++;
                    LinkedList<Integer> needTovisit = new LinkedList<>();
                    Set<Integer> needtovisitset = new HashSet<>();

                    needTovisit.add(c);
                    while (needTovisit.size() != 0) {
                        int deque = needTovisit.pollFirst();
                        visit.add(deque);
                        int curx = Math.floorDiv(deque, w);
                        int cury = deque % w;
                        for (int d = 0; d < 8; d++) {
                            int adjx = curx + dx[d];
                            int adjy = cury + dy[d];
                            int adj = adjx * w + adjy;
                            if (adjx < 0 || adjy < 0 || adjx >= h || adjy >= w || visit.contains(adj) || needtovisitset.contains(adj)) {
                                continue;
                            }
                            if (arr[adjx][adjy] == 0) {
                                visit.add(adj);
                                continue;
                            }
                            needTovisit.add(adj);
                            needtovisitset.add(adj);
                        }
                    }
                }

            }
            result.append(landCount).append("\n");
        }


        bw.write(result.toString().trim());
        bw.flush();

    }
}
