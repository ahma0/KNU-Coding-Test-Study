import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[10000001];
        prime[0] = prime[1] = true;

        for(int i = 2; i * i < 10000001; i++) {
            for(int j = 2; i * j < 10000001; j++) {
                prime[i * j] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            int ans = 0;
            for(int j = 2; j <= t / 2; j++) {
                if(!prime[j] && !prime[t - j])
                    ans++;
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}

