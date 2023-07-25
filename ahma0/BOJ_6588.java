import java.io.*;

public class Main {

    static boolean arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = "";

        arr = new boolean[1000401];

        makePrime();

        boolean flag = false;

        while(!(s = br.readLine()).equals("0")) {
            int n = Integer.parseInt(s);
            for(int i = 3; i <= n; i += 2) {
                if((n - i) % 2 != 0 && !arr[i] && !arr[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag)
                sb.append("Goldbach's conjecture is wrong.\n");
            else flag = false;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void makePrime() {
        arr[0] = arr[1] = true;

        for(int i = 2; i < Math.sqrt(1000401); i++) {
            if(arr[i]) continue;

            for(int j = i * i; j < 1000401; j += i)
                arr[j] = true;
        }
    }
}
