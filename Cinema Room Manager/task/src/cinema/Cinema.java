package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        CinemaArea area = new CinemaArea(rows, seats);
        CinemaBilling billing = new CinemaBilling(area);

        System.out.println("Total income:");
        System.out.printf("$%d%n", billing.totalIncome());
    }
}