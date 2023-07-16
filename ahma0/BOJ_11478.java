import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++)
            for(int j = i + 1; j <= s.length(); j++)
                set.add(s.substring(i, j));

        sb.append(set.size()).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}