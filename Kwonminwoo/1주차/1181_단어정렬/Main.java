import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // 5 -> 25 1181 BOJ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        List<String> arr = new ArrayList<>();
        for(int i = 0;i < cnt;i++) {
            String str = bf.readLine();
            arr.add(str);
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length())
                    return -1;
                else if (o1.length() > o2.length())
                    return 1;
                else{
                    return o1.compareTo(o2);
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        arr = arr.stream().distinct().collect(Collectors.toList());
        for(String str : arr){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}