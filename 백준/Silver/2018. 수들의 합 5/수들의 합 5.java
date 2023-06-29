import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count=1;
        int Start_index=1;
        int End_index = 1;
        int sum=1;


        while (End_index != N) {
            if (sum == N) {
                count++;End_index++;sum += End_index;
            } else if (sum > N) {
                sum = sum - Start_index;
                Start_index++;
            } else {
                End_index++;sum += End_index;
            }
        }
        System.out.println(count);

    }
}
