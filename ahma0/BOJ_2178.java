import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int map[][];
    static boolean visited[][];
    static int[] move_X = {-1, 1, 0, 0};
    static int[] move_Y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String s;

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            s = br.readLine();
            for(int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        visited = new boolean[N][M];
        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int n[];

        while(!queue.isEmpty()) {
            n = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_X = n[0] + move_X[i];
                int next_Y = n[1] + move_Y[i];

                if(next_X < 0 || next_Y < 0 || next_X >= N || next_Y >= M)
                    continue;
                if(!visited[next_X][next_Y] && map[next_X][next_Y] != 0) {
                    queue.add(new int[] {next_X, next_Y});
                    map[next_X][next_Y] = map[n[0]][n[1]] + 1;
                    visited[next_X][next_Y] = true;
                }
            }
        }
    }


}