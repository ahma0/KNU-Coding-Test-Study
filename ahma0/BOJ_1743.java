import java.io.*;
import java.util.*;

public class Solution {

    static int N, M;
    static int[] move_X = {-1, 1, 0, 0};
    static int[] move_Y = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       int T = Integer.parseInt(st.nextToken());

       arr = new int[N][M];

       for(int i = 0; i < T; i++) {
           st = new StringTokenizer(br.readLine());

           arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
       }

       visited = new boolean[N][M];

       for(int i = 0; i < arr.length; i++) {
           for(int j = 0; j < arr[i].length; j++) {
               if(!visited[i][j] && arr[i][j] == 1) {
                   search(i, j);
                   if(max < cnt) max = cnt;
                   cnt = 0;
               }
           }
       }

        System.out.println(max);

    }

    static void search(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for(int i = 0; i < 4; i++) {
            int new_X = x + move_X[i];
            int new_Y = y + move_Y[i];

            if(new_X < 0 || new_Y < 0 || new_X >= N || new_Y >= M)
                continue;

            if(!visited[new_X][new_Y] && arr[new_X][new_Y] == 1) {
                search(new_X, new_Y);
            }
        }

    }

}