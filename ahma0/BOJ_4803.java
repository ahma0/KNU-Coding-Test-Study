import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s = "";

        int index = 1;
        while(!(s = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for(int i = 0; i <= N; i++)
                parent[i] = i;

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            TreeSet<Integer> trees = new TreeSet<>();

            for(int i = 1; i <= N; i++) {
                int t = find(i);
                if(t > 0)
                    trees.add(t);
            }

            int size = trees.size();
            if(size > 1)
                sb.append("Case ").append(index).append(": A forest of ").append(size).append(" trees.\n");
            else if(size == 1)
                sb.append("Case ").append(index).append(": There is one tree.\n");
            else
                sb.append("Case ").append(index).append(": No trees.\n");

            index++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        else return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            parent[x] = 0;
            return;
        }

        if(x <= y) parent[y] = x;
        else parent[x] = y;
    }

}

