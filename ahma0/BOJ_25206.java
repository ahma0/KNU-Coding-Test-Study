import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s = "";

        String arr[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double arr2[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        double sum1 = 0, sum2 = 0;

        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            double score1 = Double.parseDouble(st.nextToken());
            String score2 = st.nextToken();

            for(int j = 0; j < arr.length; j++) {
                if(score2.equals(arr[j])) {
                    sum1 += (score1 * arr2[j]);

                    if(j != 9)
                        sum2 += score1;
                }
            }
        }

        if((sum1 / sum2) > 0)
            sb.append(String.format("%.6f", sum1 / sum2)).append("\n");
        else sb.append(0.0).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
