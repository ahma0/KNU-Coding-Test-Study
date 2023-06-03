import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 53 -> 58분 10814 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String [][]arr = new String[n][2];
        StringTokenizer tk;
        for(int i = 0; i < n;i++){
            tk = new StringTokenizer(bf.readLine());
            arr[i][0] = tk.nextToken();
            arr[i][1] = tk.nextToken();
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
               return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}