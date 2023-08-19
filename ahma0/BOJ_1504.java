import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static LinkedList<Node>[] list;
    static int[] dist;
    static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new LinkedList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += search(1, u);
        result1 += search(u, v);
        result1 += search(v, N);

        int result2 = 0;
        result2 += search(1, v);
        result2 += search(v, u);
        result2 += search(u, N);

        int ans = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);

        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int search(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int to = pq.poll().to;

            for(Node next : list[to]) {
                int nto = next.to;

                if(dist[nto] == -1 || dist[nto] > dist[to] + next.weight) {
                    dist[nto] = dist[to] + next.weight;
                    pq.add(new Node(nto, dist[nto]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}

