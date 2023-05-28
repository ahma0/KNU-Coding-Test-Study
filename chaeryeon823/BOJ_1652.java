import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 1652 / 누울 자리를 찾아라 / 실버5
 */
public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //방의 크기
        int N = Integer.parseInt(br.readLine());

        //방 구조
        int[][] arr = new int[N][N];

        int rowCnt = 0;

        int colCnt = 0;

        int cnt = 0;

        //방 구조 받아오기
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {

                if (tmp.charAt(j) == '.') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        //가로 확인하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
                if (arr[i][j] == 1) {
                    if (cnt >= 2) {
                        rowCnt++;
                        cnt = 0;
                    } else {
                        cnt = 0;
                    }
                }
            }
            if (cnt >= 2) {
                rowCnt++;
            }
            cnt = 0;
        }

        cnt = 0;

        //세로 받아오기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0) {
                    cnt++;
                }
                if (arr[j][i] == 1) {
                    if (cnt >= 2) {
                        colCnt++;
                        cnt = 0;
                    } else {
                        cnt = 0;
                    }
                }
            }
            if (cnt >= 2) {
                colCnt++;
            }
            cnt = 0;
        }
        System.out.println(rowCnt + " " + colCnt);
    }
}
