import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * [BOJ] 10816 / 숫자 카드 2 / 실버4
 */
public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int tmp=Integer.parseInt(st.nextToken());

            if(map.containsKey(tmp)) {
                bw.write(map.get(tmp)+" ");
            }
            else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
