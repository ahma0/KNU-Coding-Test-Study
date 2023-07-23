import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Star[] stars = new Star[N + 1];
        ArrayList<Node>[] arrayLists = new ArrayList[N + 1];
        boolean visited[] = new boolean[N + 1];

        for(int i = 0; i <= N; i++)
            arrayLists[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for(int i = 1; i <= N; i++) {
            for(int j = i + 1; j <= N; j++) {
                double a = Math.pow(stars[i].x - stars[j].x, 2);
                double b = Math.pow(stars[i].y - stars[j].y, 2);
                double cost = sqrtxy(a, b);
                arrayLists[i].add(new Node(j, cost));
                arrayLists[j].add(new Node(i, cost));
            }
        }

        double result = 0;
        int cnt = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int to = now.to;

            if(visited[to]) continue;
            visited[to] = true;
            result += now.cost;

            for(Node node : arrayLists[to])
                if(!visited[node.to])
                    pq.add(node);

            if(cnt++ == N) break;
        }

        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static double sqrtxy(double x, double y) {
        return Math.sqrt(x + y);
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        double cost;

        public Node(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }

}
