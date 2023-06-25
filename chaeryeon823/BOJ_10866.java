import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * [BOJ] 10866 / 덱 / 실버4
 */
public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if (tmp.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            }
            if (tmp.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            }
            if (tmp.equals("pop_front")) {
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(deque.pollFirst()+"\n");
                }
            }
            if (tmp.equals("pop_back")) {
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(deque.pollLast()+"\n");
                }

            }
            if (tmp.equals("size")) {
                bw.write(deque.size()+"\n");

            }
            if (tmp.equals("empty")) {
                if(deque.isEmpty()) {
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }

            }
            if (tmp.equals("front")) {
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(deque.getFirst()+"\n");
                }

            }
            if (tmp.equals("back")) {
                if(deque.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(deque.getLast()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();


    }
}
