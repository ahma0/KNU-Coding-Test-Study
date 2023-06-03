import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 20 -> 42분 13241 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        long num1 = Long.parseLong(tk.nextToken());
        long num2 = Long.parseLong(tk.nextToken());
        long temp = num1;
        num1 = num1 > num2 ? num1 : num2;
        num2 = temp > num2 ? num2 : temp;
        long gcd = gcd(num1, num2);
        System.out.println((num1 * num2) / gcd);
    }

    private static long gcd(long a, long b){
        while(b != 0){
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}