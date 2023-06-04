import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);

        int x = s1.length(), y = s2.length();
        String temp = "";

        while(x != 0 && y != 0) {

            if (dp[x][y] == dp[x - 1][y])
                x--;
            else if(dp[x][y] == dp[x][y - 1])
                y--;
            else {
                temp += s1.charAt(x - 1);
                x--;
                y--;
            }

        }

        StringBuffer sb = new StringBuffer(temp);
        System.out.println(sb.reverse());

    }

}
