import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int height[] = new int[W];

        for(int i = 0; i < W; i++)
            height[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;

            for(int j = 0; j < i; j++)
                left = Math.max(height[j], left);

            for(int j = i; j < W; j++)
                right = Math.max(right, height[j]);

            if(height[i] < left && height[i] < right)
                result += Math.min(left, right) - height[i];

        }

        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}