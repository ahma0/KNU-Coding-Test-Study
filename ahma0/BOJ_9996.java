import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "\\*");

        String pattern[] = new String[2];
        pattern[0] = st.nextToken();
        pattern[1] = st.nextToken();

        int l1 = pattern[0].length(), l2 = pattern[1].length();

        for(int i = 0; i < n; i++) {
            String t = br.readLine();

            if(!t.contains(pattern[0]) || !t.contains(pattern[1])) {
                sb.append("NE\n");
                continue;
            }

            if(t.length() >= l1 + l2) {
                String temp1 = t.substring(0, l1);
                String temp2 = t.substring(t.length() - l2);

                if(temp1.equals(pattern[0]) && temp2.equals(pattern[1]))
                    sb.append("DA\n");
                 else
                    sb.append("NE\n");
            }
            else sb.append("NE\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
