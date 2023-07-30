import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Node node[] = new Node[N + 1];
        arr = new int[N + 1];

        for(int i = 0; i <= N; i++)
            arr[i] = i;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            node[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            for(int j = i + 1; j <= N; j++) {
                double weight = distance(node[i], node[j]);

                pq.add(new Edge(i, j, weight));
                pq.add(new Edge(j, i, weight));
            }
        }

        double result = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(find(now.start) != find(now.end)) {
                result += now.weight;
                union(now.start, now.end);
            }
        }

        sb.append(String.format("%.2f", result)).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static double distance(Node a, Node b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        arr[y] = arr[x];
        return true;
    }

    static int find(int n) {
        if(arr[n] == n) return n;
        return find(arr[n]);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

}
