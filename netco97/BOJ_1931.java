import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int room_time[][] = new int[N][2];

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(br.readLine());
            room_time[i][0] = Integer.parseInt(st.nextToken());//시작시간
            room_time[i][1] = Integer.parseInt(st.nextToken());//종료시간
        }
        Arrays.sort(room_time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        int cur =0;
        int count = 0;

        for(int i=0;i<N;i++)
        {
            if(room_time[i][0]>=cur)
            {
                cur = room_time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
