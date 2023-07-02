import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 16  1시 46 BOJ S4
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer tk = new StringTokenizer(bf.readLine());
//        int w = Integer.parseInt(tk.nextToken());
//        int h = Integer.parseInt(tk.nextToken());
//
//        tk = new StringTokenizer(bf.readLine());
//        int p = Integer.parseInt(tk.nextToken());
//        int q = Integer.parseInt(tk.nextToken());
//        int hour = Integer.parseInt(bf.readLine());

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int hour = sc.nextInt();

        int ansW = (p + hour) % (2 * w);
        int ansH = (q + hour) % (2 * h);
        if(ansW > w) {
            ansW = 2 * w - ansW;
        }
        if(ansH > h){
            ansH = 2 * h - ansH;
        }
        System.out.println(ansW + " " + ansH);
    }
}