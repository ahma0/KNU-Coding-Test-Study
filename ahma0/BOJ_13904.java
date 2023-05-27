import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[1001];
        StringTokenizer st;

        int arr[][] = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[1]).reversed());

        for(int i = 0; i < N; i++) {
            for(int j = arr[i][0]; j > 0; j--) {
                if(score[j] == 0) {
                    score[j] = arr[i][1];
                    break;
                }
            }
        }

        int sum = 0;

        for(int i = 1; i < score.length; i++)
            sum += score[i];

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}