import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 47 -> 19 32분 2839boj
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        while (true){
            if(n % 5 == 0){
                cnt += n / 5;
                break;
            }
            n -= 3;
            if(n < 0){
                cnt = -1;
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}