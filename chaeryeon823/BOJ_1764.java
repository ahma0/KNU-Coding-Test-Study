import java.io.*;
import java.util.*;

/**
 * [BOJ] 1764 / 듣보잡 / 실버4
 */
public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet=new HashSet<>();
        for(int i=0;i<N;i++) {
            hashSet.add(br.readLine());
        }

        LinkedList<String> answer=new LinkedList<>();
        for(int i=0;i<M;i++) {
            String tmp=br.readLine();
            if(hashSet.contains(tmp)) {
                answer.add(tmp);
            }
        }
        Collections.sort(answer);

        bw.write(answer.size()+"\n");
        for (String s : answer) {
            bw.write(s+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
