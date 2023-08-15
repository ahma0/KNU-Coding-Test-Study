import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static LinkedList<Node>[] list;
    static int dist[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        list = new LinkedList[V + 1];

        for(int i = 0; i <= V; i++)
            list[i] = new LinkedList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        visited = new boolean[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, -1);

        search(start);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == -1)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int to = now.to;

            for(Node next : list[to]) {
                if(dist[next.to] == -1 || dist[next.to] > dist[to] + next.weight) {
                    dist[next.to] = dist[to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
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

