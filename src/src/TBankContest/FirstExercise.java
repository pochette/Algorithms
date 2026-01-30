package TBankContest;

import java.util.Scanner;

public class FirstExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long L = sc.nextLong();
        long W = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();

        long shotsL = (L - A + 1 + A - 1) / A; // ceil((L - A + 1) / A)
        long shotsW = (W - B + 1 + B - 1) / B; // ceil((W - B + 1) / B)

        System.out.println(shotsL * shotsW);
    }
}
