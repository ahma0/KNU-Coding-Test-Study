import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static LinkedList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        list = new LinkedList<>();

        if(n <= 10) sb.append(n).append("\n");
        else if(n > 1022) sb.append("-1\n");
        else {
            for(int i = 0; i < 10; i++)
                bp(i, 1);

            Collections.sort(list);
            sb.append(list.get(n)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void bp(long num, int idx) {
        if(idx > 10) return;

        list.add(num);

        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }

}