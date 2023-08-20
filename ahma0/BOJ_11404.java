import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                if(i != j)
                    map[i][j] = INF;

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(c, map[a][b]);
        }

        find();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == INF)
                    map[i][j] = 0;

                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void find() {
        for(int k = 1; k <= N; k++)
            for(int i = 1; i <= N; i++) {
                if(k == i)
                    continue;

                for(int j = 1; j <= N; j++) {
                    if(map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
    }

}

