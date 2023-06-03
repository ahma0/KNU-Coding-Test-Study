import java.io.*;
import java.util.*;

public class Main {
    static int N, S, X, Y;
    static int[][] arr;
    static int[] move_X = {1, -1, 0, 0};
    static int[] move_Y = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<Node> nodes = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        List<Node> list = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] != 0)
                    list.add(new Node(i, j, arr[i][j], 0));
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++)
            nodes.add(list.get(i));

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        search();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append(arr[X - 1][Y - 1] + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search() {

        while(!nodes.isEmpty()) {
            Node now = nodes.poll();

            if(now.time == S) return;

            for(int j = 0; j < 4; j++) {
                int new_X = now.x + move_X[j];
                int new_Y = now.y + move_Y[j];

                if(new_X < 0 || new_Y < 0 || new_X >= N || new_Y >= N)
                    continue;

                if(arr[new_X][new_Y] == 0) {
                    arr[new_X][new_Y] = now.num;
                    nodes.offer(new Node(new_X, new_Y, now.num, now.time + 1));
                }

            }
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int num;
        int time;

        Node (int x, int y, int num, int time) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

}
