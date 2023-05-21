import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][N];
        int visited[] = new int[N];
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int fr = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[fr][to] = 1;
            map[to][fr] = 1;
        }

        dfs(start, visited,map);
        System.out.println();
        Arrays.fill(visited,0); //배열 한번에 초기화
        bfs(start,visited,map);
    }
    public static void dfs(int idx, int visited[], int map[][]){
        int fr = idx;
        visited[fr] = 1;
        System.out.print(fr+" ");
        for(int i=1;i<N;i++)
        {
            if(map[fr][i]==1 && visited[i]==0)
            {
                dfs(i, visited, map);
            }
        }
    }

    public static void bfs(int idx,int visited[],int map[][])
    {
        Queue<Integer> q =  new LinkedList<>();
        q.add(idx);
        visited[idx] = 1;

        while(!q.isEmpty())
        {
            int cur = q.remove();
            System.out.print(cur+" ");
            for(int i=1;i<N;i++)
            {
                if(map[cur][i]==1&&visited[i]==0)
                {
                    q.add(i);
                    visited[i]=1;
                }
            }
        }
    }
}