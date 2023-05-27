import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 7분 - 22분
        Scanner sc = new Scanner(System.in);
        double totalNum = 0;
        double totalPoint = 0;

        for(int i = 0;i < 3;i++){
            sc.next();
            double num = sc.nextDouble();
            String grade = sc.next();
            double point = 0;
            boolean flag = false;

            switch (grade){
                case "A+":
                    point = num * 4.5;
                    break;
                case "A0":
                    point = num * 4.0;
                    break;
                case "B+":
                    point = num * 3.5;
                    break;
                case "B0":
                    point = num * 3.0;
                    break;
                case "C+":
                    point = num * 2.5;
                    break;
                case "C0":
                    point = num * 2.0;
                    break;
                case "D+":
                    point = num * 1.5;
                    break;
                case "D0":
                    point = num * 1.0;
                    break;
                case "F":
                    point = 0;
                    break;
                default:
                    flag = true;
                    break;
            }
            if(!flag){
                totalPoint += point;
                totalNum += num;
            }
        }
        sc.close();
        System.out.println(totalPoint/totalNum);
    }
}