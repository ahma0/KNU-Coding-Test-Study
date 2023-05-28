import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for(int i = 0; i < arr.length; i++)
            arr[i] = i;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(T == 0)
                union(a, b);

            if(T == 1) {
                if(find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if(x == arr[x]) return x;
        else return arr[x] = find(arr[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x > y) arr[y] = x;
        else arr[x] = y;
    }

}
