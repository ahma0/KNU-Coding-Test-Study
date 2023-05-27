import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String arr[];
        boolean flag = false;

        for(int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            arr = new String[T];

            for(int j = 0; j < T; j++)
                arr[j] = br.readLine().replaceAll(" ", "");

            Arrays.sort(arr);

            for(int j = 0; j < T - 1; j++)
                if(arr[j + 1].startsWith(arr[j])) flag = true;

            if(flag) sb.append("NO\n");
            else sb.append("YES\n");

            flag = false;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}