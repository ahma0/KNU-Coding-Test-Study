import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int A[] = new int[K + 1];
        int B[] = new int[K + 1];

        A[0] = 1;
        B[1] = 1;

        for(int i = 2; i <= K; i++) {
            A[i] = A[i - 1] + A[i - 2];
            B[i] = B[i - 1] + B[i - 2];
        }

        sb.append(A[K]).append(" ").append(B[K]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}

