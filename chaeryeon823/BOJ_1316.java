import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //단어의 개수
        int N = Integer.parseInt(br.readLine());
        boolean check = true;
        ArrayList<Character> list = new ArrayList<Character>();

        int cnt = 0;


        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            list.add(tmp.charAt(0));
            for (int j = 1; j < tmp.length(); j++) {
                if (tmp.charAt(j - 1) == tmp.charAt(j)) {
                    continue;
                } else {
                    if (list.contains(tmp.charAt(j))) {
                        check = false;
                        break;
                    } else {
                        list.add(tmp.charAt(j));
                    }
                }
            }
            if (check) {
                cnt++;
            }
            check = true;
            list.clear();
        }
        System.out.println(cnt);

    }
}
