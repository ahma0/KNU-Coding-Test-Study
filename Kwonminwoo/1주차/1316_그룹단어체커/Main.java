import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //27분
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int paper[num][2] = new int[][];
        for(int i = 0;i < num;i++){
            paper[i][0] = scanner.nextInt(); // x
            paper[i][1] = scanner.nextInt(); // y
        }
        int overArea = 0;

        for(int i = 0; i < num;i++){
            int x = paper[i][0];
            int y = paper[i][1];
            for(int j = i == num - 1 ? i + 2 : i + 1;j < num;j++){
                int nextX = paper[j][0];
                int nextY = paper[j][1];

                if(x <= nextX && y >= nextY){
                    overArea += (10 - nextX - x) * (10 - y - nextY);
                }
                System.out.println("overArea = " + overArea);
            }
        }
    }
}