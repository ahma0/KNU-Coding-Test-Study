import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[D];

        for(int i = 1; i <= K / 2; i++) {
            for(int j = i + 1; j < K; j++) {
                arr[0] = i;
                arr[1] = j;

                for(int t = 2; t < D; t++)
                    arr[t] = arr[t - 1] + arr[t - 2];

                if(arr[D - 1] == K) {
                    sb.append(arr[0]).append("\n");
                    sb.append(arr[1]).append("\n");

                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }


    }

}