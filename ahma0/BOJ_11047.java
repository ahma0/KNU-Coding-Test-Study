import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            if(t <= K)
                stack.push(t);
        }

        int cnt = 0;

        while(K != 0) {
            int t = stack.pop();

            cnt += K / t;
            K %= t;
        }

        sb.append(cnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}