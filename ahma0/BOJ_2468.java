import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(list.isEmpty() || !list.contains(graph[i][j]))
                    list.add(graph[i][j]);
            }
        }

        int max = -1;
        for(int num : list) {
            visited = new boolean[N][N];
            int area = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && graph[i][j] > num) {
                        search(i, j, num);
                        area++;
                    }
                }
            }

            max = Math.max(max, area);

        }

        if(max == 0)
            sb.append(1).append("\n");
        else
            sb.append(max).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int x, int y, int num) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= N
                    || visited[newX][newY]
                    || graph[newX][newY] <= num)
                continue;

            search(newX, newY, num);

        }
    }

}
