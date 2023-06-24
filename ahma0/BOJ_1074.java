import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r;       //y
    static int c;       //x
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        partition(0, 0, size);

        sb.append(count - 1).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void partition(int startX, int startY, int size) {

        if(size <= 2) {
            findXY(startX, startY);
            return;
        }

        int half = size / 2;

        boolean left = startX <= c && startX + half > c;
        boolean right = startX + half <= c && startX + size > c;
        boolean up = startY <= r && startY + half > r;
        boolean down = startY + half <= r && startY + size > r;

        if(left && up)
            partition(startX, startY, half);
        else if(right && up) {
            count += half * half;
            partition(startX + half, startY, half);
        }
        else if(left && down) {
            count += (half * half) * 2;
            partition(startX, startY + half, half);
        }
        else if(right && down) {
            count += (half * half) * 3;
            partition(startX + half, startY + half, half);
        }

    }

    static void findXY(int x, int y) {
        for(int j = y; j < y + 2; j++)
            for(int i = x; i < x + 2; i++) {
                count++;
                if(i == c && j == r)
                    return;
            }
    }

}