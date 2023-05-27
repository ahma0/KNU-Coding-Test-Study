import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //01:59 ~
    static LinkedList<Integer>[] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];

        for(int i = 0; i < list.length; i++)
            list[i] = new LinkedList<>();

        int dig[] = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            dig[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i < dig.length; i++) {
            if(dig[i] == 0)
                pq.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        visited = new boolean[N + 1];

        while(!pq.isEmpty()) {
            int t = pq.poll();
            sb.append(t + " ");
            visited[t] = true;

            Collections.sort(list[t]);

            for(Integer now : list[t]) {
                dig[now]--;
                if(dig[now] == 0) {
                    pq.add(now);
                    visited[now] = true;
                }
            }
        }

        for(int i = 1; i < list.length; i++)
            if(!visited[i]) sb.append(i + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
