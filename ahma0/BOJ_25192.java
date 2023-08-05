import java.io.*;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N --> 0) {
            String s = br.readLine();

            if(s.equals("ENTER"))
                set.clear();
            else
                if(!set.contains(s)) {
                    set.add(s);
                    cnt++;
                }
        }

        sb.append(cnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}