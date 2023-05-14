package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize cinema
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        CinemaHall area = new CinemaHall(rows, seats);
        CinemaManager manager = new CinemaManager(area);

        manager.run();
    }
}