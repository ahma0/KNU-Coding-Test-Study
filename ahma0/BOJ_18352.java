import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, X;
    static LinkedList<Integer>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];
        for(int i = 1; i <= N; i++)
            list[i] = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        search();

        int cnt = 0;
        for(int i = 0; i <= N; i++)
            if(dist[i] == K) {
                sb.append(i).append("\n");
                cnt++;
            }

        if(cnt == 0)
            sb.append(-1).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void search() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(X);
        dist[X] = 0;

        while(!pq.isEmpty()) {
            int to = pq.poll();

            for(Integer next : list[to]) {
                if(dist[next] == -1 || dist[next] > dist[to] + 1) {
                    dist[next] = dist[to] + 1;
                    pq.add(next);
                }
            }
        }
    }

}

