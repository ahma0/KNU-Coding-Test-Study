import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 03 -> 15 10773 BOJ S4
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        List<Integer> stack = new ArrayList<Integer>(k);
        int result = 0;
        int top = -1;
        for(int i = 0;i < k;i++){
            int n = Integer.parseInt(bf.readLine());
            if(top != -1 && n == 0){
                stack.remove(top--);
                continue;
            }
            stack.add(++top, n);
        }
        for(int i = 0;i < stack.size();i++){
            result += stack.get(i);
        }
        System.out.println(result);
    }
}