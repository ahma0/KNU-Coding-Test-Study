import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 25 ->  1시 5분 BOJ S3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer str = new StringTokenizer(br.readLine());

            LinkedList<int[]> q = new LinkedList<>();

            for(int j = 0;str.hasMoreTokens() ; j++) {
                q.add(new int[] {j,Integer.parseInt(str.nextToken())});
            }

            int count = 0;

            while(!q.isEmpty()) {
                int[] temp = q.poll();
                boolean check = true;

                for(int j = 0 ; j < q.size() ; j++) {
                    if(temp[1] < q.get(j)[1]) {
                        q.add(temp);

                        for(int k = 0 ; k < j ; k++)
                            q.add(q.poll());

                        check = false;
                        break;
                    }
                }

                if(!check)
                    continue;
                count++;
                if(temp[0] == M)
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}