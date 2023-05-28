import java.io.*;

public class Main {

    static int N;
    static String str[];
    static int move_X[] = {-1, 1, 0, 0};
    static int move_Y[] = {0, 0, -1, 1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        str = new String[N];

        for(int i = 0; i < N; i++)
            str[i] = br.readLine();

        visited = new boolean[N][N];
        int cnt[] = new int[2];

        cnt[0] = count();

        for(int i = 0; i < str.length; i++)
            str[i] = str[i].replaceAll("G", "R");

        visited = new boolean[N][N];

        cnt[1] = count();

        System.out.println(cnt[0] + " " + cnt[1]);

    }

    static int count() {
        int cnt = 0;
        for(int i = 0; i < str.length; i++) {
            for(int j = 0; j < str[i].length(); j++) {
                if(!visited[i][j]) {
                    search(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void search(int x, int y) {
        visited[x][y] = true;
        char temp = str[x].charAt(y);

        for(int i = 0; i < 4; i++) {
            int new_X = x + move_X[i];
            int new_Y = y + move_Y[i];

            if(new_X < 0 || new_Y < 0 || new_X >= N || new_Y >= N)
                continue;

            if(!visited[new_X][new_Y] && str[new_X].charAt(new_Y) == temp)
                search(new_X, new_Y);
        }
    }

}
