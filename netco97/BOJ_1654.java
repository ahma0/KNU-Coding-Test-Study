import java.io.*;
import java.util.*;

public class BOJ_1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr [] = new int[K];

        for(int i=0;i<K;i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int max = arr[arr.length-1]+1;

        System.out.println(binary(max,arr,N));


    }
    public static int binary(int max,int arr[],int N){
        int min=1;
        int mid=0;

        while(min<max)
        {
            mid = (min+max)/2;
            int count =0;
            for(int i=0;i<arr.length;i++)
            {
                count += arr[i]/mid;
            }
            if(count<N)
                max = mid;
            else
                min = mid+1;
            System.out.println(min);
        }
        return min-1;
    }
}