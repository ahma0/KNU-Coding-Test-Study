import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int white = 0;
    static int blue = 0;
    static int arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++)
            {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }
    public static void partition(int row,int col, int N){
        if(isColor(row,col,N))
        {
            if(arr[row][col]==1)
                blue++;
            else
                white++;
            return;
        }
        N = N/2;
        partition(row,col+N,N); //1사분면
        partition(row,col,N); //2사분면
        partition(row+N,col,N); //3사분면
        partition(row+N,col+N,N); //4사분면

    }
    public static boolean isColor(int row,int col,int N){
        int cur = arr[row][col];
        for(int i=row;i<row+N;i++)
        {
            for(int j=col;j<col+N;j++)
            {
                if(arr[i][j]!=cur)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
