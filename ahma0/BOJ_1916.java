import java.io.*;
import java.util.*;

public class Main {

    static LinkedList<City>[] list;
    static boolean[] visited;
    static int dist[];
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new LinkedList[N + 1];

        for(int i = 0; i <= N; i++)
            list[i] = new LinkedList<>();

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new City(b, c));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];

        search();

        sb.append(dist[end]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search() {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            City now = pq.poll();
            int to = now.to;

            if(visited[to]) continue;

            visited[to] = true;

            for(City n : list[to]) {
                int nextTo = n.to;
                if(!visited[nextTo] && dist[nextTo] > dist[to] + n.dist) {
                    dist[nextTo] = dist[to] + n.dist;
                    pq.add(new City(nextTo, dist[nextTo]));
                }
            }
        }
    }

    static class City implements Comparable<City> {
        int to;
        int dist;

        public City(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(City o) {
            return this.dist - o.dist;
        }
    }

}

