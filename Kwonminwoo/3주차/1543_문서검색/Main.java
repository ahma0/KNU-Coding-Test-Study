import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10 -> 40 1543 BOJ S4
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String find = bf.readLine();

        char[] chars = str.toCharArray();
        int ans = 0;
        boolean flag = true;
        for(int i = 0; i < chars.length;i++){
            for(int j = 0; j < find.length();j++){
                if((i + j) >= chars.length || chars[i + j] != find.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
                i += find.length() - 1;
            }
            flag = true;
        }
        System.out.println(ans);
    }
}