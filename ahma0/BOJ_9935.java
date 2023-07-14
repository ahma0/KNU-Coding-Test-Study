import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String temp = br.readLine();
        int sl = s.length();
        int tl = temp.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < sl; i++) {
            int cnt = 0;
            stack.push(s.charAt(i));

            if(stack.size() >= tl) {
                for(int j = 0; j < tl; j++) {
                    if(stack.get(stack.size() - tl + j) == temp.charAt(j))
                        cnt++;

                    if(cnt == tl)
                        for(int k = 0; k < tl; k++)
                            stack.pop();
                }
            }
        }

        if(stack.isEmpty()) sb.append("FRULA");
        else
            for(Character ch : stack)
                sb.append(ch);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}