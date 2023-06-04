import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [BOJ] 10828 / 스택 / 실버4
 */
public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> arr = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            if (tmp.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                arr.push(num);
            }
            if (tmp.equals("top")) {
                if (arr.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(arr.peek() + "\n");
                }
            }
            if (tmp.equals("size")) {
                bw.write(arr.size() + "\n");
            }
            if (tmp.equals("empty")) {
                if (arr.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
            if (tmp.equals("pop")) {
                if (arr.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(arr.pop() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
