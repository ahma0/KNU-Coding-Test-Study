import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int max = 0, max_index = 0;
    static LinkedList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(br.readLine());

        graph = new LinkedList[V + 1];
        for(int i = 0; i <= V; i++)
            graph[i] = new LinkedList<>();

        StringTokenizer st;
        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            String temp;
            while(!(temp = st.nextToken()).equals("-1"))
                graph[n].add(new Node(Integer.parseInt(temp), Integer.parseInt(st.nextToken())));
        }

        visited = new boolean[V + 1];
        visited[1] = true;
        search(1, 0);

        visited = new boolean[V + 1];
        visited[max_index] = true;
        search(max_index, 0);

        sb.append(max).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int index, int cnt) {
        if(max < cnt) {
            max = cnt;
            max_index = index;
        }

        for(Node n : graph[index]) {
            if(!visited[n.to]) {
                visited[n.to] = true;
                search(n.to, n.weight + cnt);
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

