import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 43 ->  BOJ S4
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        int pushNum = 0;
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(bf.readLine());
            String order = tk.nextToken();
            switch (order){
                case "push":
                    pushNum = Integer.parseInt(tk.nextToken());
                    queue.add(pushNum);
                    break;
                case "pop":
                    pop(queue, sb);
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    front(queue, sb);
                    break;
                case "back":
                    back(queue, sb, pushNum);
                    break;
            }
        }
        System.out.println(sb);
    }
    static private void pop(Queue<Integer> queue, StringBuilder sb){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(queue.remove()).append("\n");
    }

    static private void back(Queue<Integer> queue, StringBuilder sb, int pushNum) {
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(pushNum).append("\n");
    }

    static private void front(Queue<Integer> queue, StringBuilder sb){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(queue.element()).append("\n");
    }
}