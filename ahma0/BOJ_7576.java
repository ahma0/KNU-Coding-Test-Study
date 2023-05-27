import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] move_X = {1, -1, 0, 0};
    static int[] move_Y = {0, 0, -1, 1};
    static int day = 0;
    static Queue<Tomato> tomatoes = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1)
                   tomatoes.add(new Tomato(i, j, 0));
            }
        }

        visited = new boolean[N][M];

        bfs();

        for(int[] i : arr) {
            for(int j : i) {
                if(j == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day - 1);
    }

    public static void bfs() {
        while(!tomatoes.isEmpty()) {
            Tomato tomato = tomatoes.poll();
            int now_X = tomato.x;
            int now_Y = tomato.y;
            int days = tomato.day + 1;

            for(int i = 0; i < 4; i++) {
                int new_X = now_X + move_X[i];
                int new_Y = now_Y + move_Y[i];

                if(new_X < 0 || new_Y < 0 || new_X >= N || new_Y >= M)
                    continue;

                day = days;
                if (arr[new_X][new_Y] == 0) {
                    tomatoes.add(new Tomato(new_X, new_Y, days));
                    arr[new_X][new_Y] = 1;
                }

            }
        }
    }

    public static class Tomato {
        int x;
        int y;
        int day;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}