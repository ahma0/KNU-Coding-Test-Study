import java.io.*;
import java.util.Arrays;

public class Main {

    static int max = 1104001;
    static boolean[] distinct = new boolean[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            sb.append("2\n");
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        checkPrime(n);

        for(int i = n; i < max; i++) {
            if(i < 10 && distinct[i]) {
                sb.append(i).append("\n");
                break;
            }
            else if(checkPelin(String.valueOf(i)) && distinct[i]) {
                sb.append(i).append("\n");
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void checkPrime(int n) {
        Arrays.fill(distinct, true);

        for(int i = 2; i <= Math.sqrt(max - 1); i++) {
            if(distinct[i]) {
                for(int j = i; j * i < max; j++)
                    distinct[i * j] = false;
            }
        }
    }

    static boolean checkPelin(String n) {
        int start = 0;
        int end = n.length() - 1;

        while(start <= end) {
            if (n.charAt(start) != n.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

}