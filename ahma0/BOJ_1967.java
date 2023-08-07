import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int max = 0, max_index = 0;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[max_index] = true;
        dfs(max_index, 0);

        sb.append(max).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int index, int cnt) {
        if(max < cnt) {
            max = cnt;
            max_index = index;
        }

        for(Node n : list[index]) {
            if(!visited[n.to]) {
                visited[n.to] = true;
                dfs(n.to, cnt + n.weight);
            }
        }
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}

