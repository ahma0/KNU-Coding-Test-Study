import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * [BOJ] 10867 / 중복 빼고 정렬하기 / 실버5
 */
public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> arr=new ArrayList<>();

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int tmp=Integer.parseInt(st.nextToken());
            if(!arr.contains(tmp)) {
                arr.add(tmp);
            }
        }
        Collections.sort(arr);

        for(int i=0;i<arr.size();i++) {
            System.out.print(arr.get(i)+ " ");
        }

    }
}
