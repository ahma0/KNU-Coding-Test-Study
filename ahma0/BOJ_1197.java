import java.io.*;
import java.util.*;

public class Main {

    static int N, M, cnt = 0;
    static ArrayList<Node>[] arrayList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < arrayList.length; i++)
            arrayList[i] = new ArrayList<>();


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arrayList[a].add(new Node(b, c));
            arrayList[b].add(new Node(a, c));
        }

        search();
        sb.append(cnt).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int to = now.to;
            int cost = now.cost;

            if(visited[to]) continue;
            visited[to] = true;
            cnt += cost;

            for(Node next : arrayList[to]) {
                if(!visited[next.to])
                    pq.add(next);
            }

        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}