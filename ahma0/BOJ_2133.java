import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 2 != 0) {
            System.out.println(0);
            return;
        }

        if(N == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N + 1];

        arr[0] = 1;
        arr[2] = 3;

        //33(arr[4] * 3 -> 11 * 3) + 6(arr[2] * 2 -> 3 * 2) + 2(arr[0] * 2) = 41(arr[6])

        for(int i = 4; i < arr.length; i += 2) {
            arr[i] = 3 * arr[i - 2];
            for(int j = 0; j < i - 2; j += 2)
                arr[i] += 2 * arr[j];
        }

        System.out.println(arr[N]);

    }

}
