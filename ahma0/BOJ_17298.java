import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
                arr[stack.pop()] = arr[i];

            stack.push(i);
        }

        while(!stack.isEmpty())
            arr[stack.pop()] = -1;

        for(int i : arr)
            sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}