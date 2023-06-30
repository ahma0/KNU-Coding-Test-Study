import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int movedX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int movedY[] = {1, 0, -1, 1, -1, 1, 0, -1};
    static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            arr = new int[H][W];
            visited = new boolean[H][W];

            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < W; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < H; i++)
                for(int j = 0; j < W; j++)
                    if(!visited[i][j] && arr[i][j] == 1) {
                        search(i, j);
                        cnt++;
                    }

            sb.append(cnt).append("\n");
            cnt = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int newX = x + movedX[i];
            int newY = y + movedY[i];

            if(newX < 0 || newY < 0 || newX >= H || newY >= W)
                continue;

            if(arr[newX][newY] == 1 && !visited[newX][newY])
                search(newX, newY);
        }
    }

}