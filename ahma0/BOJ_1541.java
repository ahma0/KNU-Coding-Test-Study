import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), "\\-");

        int sum = Integer.MAX_VALUE;
        while(st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "\\+");

            while(st2.hasMoreTokens())
                temp += Integer.parseInt(st2.nextToken());

            if(sum == Integer.MAX_VALUE)
                sum = temp;
            else sum -= temp;
        }

        sb.append(sum).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
