import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 44 -> 17  18870 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] before = new int[n];
        Integer [] sorted = new Integer[n];
        Map<Integer, Integer> list = new HashMap<>();
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            before[i] = Integer.parseInt(tk.nextToken());
            sorted[i] = before[i];
        }
        Arrays.sort(sorted);
        for(int i = 0, rank = 0;i < sorted.length;i++){
            if(!list.containsKey(sorted[i])){
                list.put(sorted[i], rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < before.length;i++){
            sb.append(list.get(before[i])).append(" ");
        }
        System.out.println(sb);
    }
}