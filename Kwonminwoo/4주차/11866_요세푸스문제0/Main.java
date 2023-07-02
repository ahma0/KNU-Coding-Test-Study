import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 07 -> 21 BOJ S5
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());
        for(int i = 0;i < n;i++){
            queue.add(i + 1);
        }
        int i = 0;
        while(!queue.isEmpty()){
            if(i == k - 1){
                i = 0;
                sb.append(queue.remove()).append(", ");
                continue;
            }
            queue.add(queue.remove());
            i++;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println("<" + sb + ">");
    }

}