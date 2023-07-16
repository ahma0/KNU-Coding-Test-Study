import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[101][101];

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = a; j < a + 10; j++) {
                for(int k = b; k < b + 10; k++)
                    if(!arr[j][k]) {
                        arr[j][k] = true;
                        cnt++;
                    }
            }
        }

        sb.append(cnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}