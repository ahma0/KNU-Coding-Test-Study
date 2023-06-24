import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // 20 -> 47 20920 BOJ S3
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0;i < n;i++){
            String word = bf.readLine();
            if(word.length() >= m){
                int cnt = 0;
                if(map.containsKey(word)){
                    cnt = map.get(word);
                }
                map.put(word, ++cnt);
            }
        }
        List<String> list = new ArrayList<>();
        list = map.keySet().stream().collect(Collectors.toList());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) > map.get(o2))
                    return -1;
                else if(map.get(o1) < map.get(o2))
                    return 1;
                else{
                    if(o1.length() > o2.length())
                        return -1;
                    else if (o1.length() < o2.length())
                        return 1;
                    else{
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < list.size();i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static int sortCharAt(String str1, String str2){
        String large = str1.length() > str2.length() ? str1 : str2;
        String small = str1.length() > str2.length() ? str2 : str1;
        for(int i = 0;i < small.length();i++){
            if(small.charAt(i) > large.charAt(i))
                return 1;
            else if(small.charAt(i) < large.charAt(i))
                return -1;
        }
        return 0;
    }
}