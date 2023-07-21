import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();

        int arr[] = new int[10];

        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '6')
                arr[9] += 1;
            else
                arr[num.charAt(i) - '0'] += 1;
        }

        if(arr[9] % 2 == 0)
            arr[9] /= 2;
        else arr[9] = arr[9] / 2 + 1;

        Arrays.sort(arr);

        sb.append(arr[9]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}