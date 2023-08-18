import java.io.*;
import java.util.*;

public class Main {

    static int N, M, X;
    static LinkedList<Node>[] graph;
    static LinkedList<Node>[] reverse_graph;
    static int[] dist, reverse_dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1];
        reverse_graph = new LinkedList[N + 1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
            reverse_graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            reverse_graph[b].add(new Node(a, c));
        }

        dist = new int[N + 1];
        reverse_dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(reverse_dist, -1);

        search(graph, dist);
        search(reverse_graph, reverse_dist);

        int max = -1;
        for(int i = 1; i <= N; i++)
            max = Math.max(max, dist[i] + reverse_dist[i]);

        sb.append(max).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(LinkedList<Node>[] list, int[] distance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        distance[X] = 0;

        while(!pq.isEmpty()) {
            int to = pq.poll().to;

            for(Node next : list[to]) {
                int nto = next.to;
                if(distance[nto] == -1 || distance[nto] > distance[to] + next.time) {
                    distance[nto] = distance[to] + next.time;
                    pq.add(new Node(nto, distance[nto]));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        int to;
        int time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

}

