import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());

            if(!list.contains(t))
                list.add(t);
        }

        Collections.sort(list);

        for(Integer i : list)
            sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}