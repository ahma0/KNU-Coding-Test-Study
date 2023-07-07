import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            set1.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            set2.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;

        for(Integer i : set1) {
            if(set2.contains(i))
                cnt += 2;
        }

        sb.append(N + M - cnt).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}