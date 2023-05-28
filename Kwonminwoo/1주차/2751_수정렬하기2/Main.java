import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10 -> 20 2751boj
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(bf.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < cnt; i++){
            arr.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(arr);
        for(int i = 0;i < cnt;i++){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}