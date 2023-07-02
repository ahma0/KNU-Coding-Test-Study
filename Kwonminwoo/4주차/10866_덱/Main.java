import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 51 -> 02 BOJ S4
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(bf.readLine());
        int num = 0;
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer tk = new StringTokenizer(bf.readLine());

            String order = tk.nextToken();
            switch (order){
                case "push_back":
                    num = Integer.parseInt(tk.nextToken());
                    deque.addFirst(num);
                    break;
                case "push_front":
                    num = Integer.parseInt(tk.nextToken());
                    deque.addLast(num);
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.removeLast()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.removeFirst()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.peekLast()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(deque.peekFirst()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}