import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 02 -> 08 25192 BOJ S4
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        Set<String> list = new HashSet<>();
        for(int i = 0; i < n;i++){
            String chat =  bf.readLine();
            if(chat.equals("ENTER")){
                list.clear();
                continue;
            }
            if(!list.contains(chat)) {
                cnt++;
                list.add(chat);
            }
        }
        System.out.println(cnt);
    }
}