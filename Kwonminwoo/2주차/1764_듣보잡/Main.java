import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 19 -> 1 21 1764 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        String [] arr1 = new String[n];
        String [] arr2 = new String[m];

        for(int i = 0;i < n;i++){
            arr1[i] = bf.readLine();
        }
        for(int i = 0;i < m;i++){
            arr2[i] = bf.readLine();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(String str2 : arr2){
            if(binarySearch(arr1, str2)){
                cnt++;
                sb.append(str2).append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static boolean binarySearch(String [] arr, String target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int centerIndex = (left + right) / 2;
            String center = arr[centerIndex];
            int check = checkLarge(target, center);
            if(check == 1){
                left = centerIndex + 1;
            }else if(check == 2){
                right = centerIndex - 1;
            } else{
                return true;
            }
        }
        return false;
    }
    private static int checkLarge(String str1, String str2){
        for(int i = 0;i < str1.length() && i < str2.length();i++){
            if(str1.charAt(i) > str2.charAt(i)){
                return 1;
            }else if(str1.charAt(i) < str2.charAt(i))
                return 2;
        }
        if(str1.length() == str2.length()){
            return 0;
        }
        if(str1.length() > str2.length()){
            return 1;
        }
        return 2;
    }
}