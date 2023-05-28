import java.io.*;
import java.util.*;

public class Main {

    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[N];

        for(int i = 0; i < arr.length; i++)
            arr[i] = i;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());

                if(t == 1)
                    union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());

        int arr2[] = new int[M];

        for(int i = 0; i < M; i++)
            arr2[i] = Integer.parseInt(st.nextToken()) - 1;

        boolean flag = true;

        for(int i = 1; i < M; i++) {
            if(union(arr2[i - 1], arr2[i]))
                flag = false;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        arr[y] = arr[x];
        return true;
    }

    static int find(int n) {
        if(arr[n] == n) return n;
        return find(arr[n]);
    }

}
