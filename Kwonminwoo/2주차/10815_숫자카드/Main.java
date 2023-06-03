import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 55 -> 13 10815 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String str1 = bf.readLine();
        List<Integer> cards = new ArrayList<>();
        StringTokenizer tk = new StringTokenizer(str1);
        for(int i = 0;i < N;i++){
            cards.add(Integer.parseInt(tk.nextToken()));
        }
        cards.sort(Comparator.naturalOrder());
        int M = Integer.parseInt(bf.readLine());
        tk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(tk.nextToken());
            int left = 0;
            int right = N - 1;
            boolean flag = false;
            while (left <= right){
                int mid = (left + right) / 2;
                int midNum = cards.get(mid);
                if(num > midNum){
                    left = mid + 1;
                }else if(num < midNum){
                    right = mid - 1;
                }else{
                    sb.append("1").append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
               sb.append("0").append(" ");
            }
        }
        System.out.println(sb);
    }
}