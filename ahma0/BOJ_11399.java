import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //10:44 ~ 10:58
    //10:26 ~ 10:30

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
            pq.add(Integer.parseInt(st.nextToken()));

        int sum = 0;
        int arr[] = new int[N + 1];

        if(N < 2) {
            System.out.println(pq.poll());
            return;
        }

        arr[0] = pq.poll();
        arr[1] = arr[0] + pq.poll();

        sum += arr[0] + arr[1];

        for(int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + pq.poll();
            sum += arr[i];
        }

        System.out.println(sum);
    }


}
