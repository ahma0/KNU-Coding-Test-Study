import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 15 -> 42 28분  9012 S4
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++){
            Stack<String> stack = new Stack<>();
            boolean flag = false;
            String str = bf.readLine();
            String[] split = str.split("");
            for(int j = 0;j < split.length;j++){
                if(split[j].equals("(")){
                    stack.push(split[j]);
                }else{
                    if(stack.size() == 0){
                        flag = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(flag){
                sb.append("NO");
            }else{
                if(stack.size() == 0){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}