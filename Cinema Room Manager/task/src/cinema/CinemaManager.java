package cinema;

import java.util.Scanner;

final public class CinemaManager {

    final private CinemaHall cinema;
    final private CinemaBilling billing;

    public CinemaManager(CinemaHall area) {
        cinema = area;
        billing = new CinemaBilling(cinema);
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exited = false;

        while (!exited) {
            showMenu();
            int cmd = scanner.nextInt();

            switch (cmd) {
                case 1 -> cinema.print();
                case 2 -> buyTicket();
                case 3 -> printStatistics();
                case 0 -> exited = true;
                default -> System.out.println("Unknown command");
            }
        }
    }

    private void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        try {
            CinemaSeat seat = billing.buy(rowNum, seatNum);
            System.out.printf("%nTicket price: $%d%n", billing.getPrice(seat));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            buyTicket();
        }
    }

    private void printStatistics() {
        int total = cinema.total();
        int free = cinema.free();

        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", (total - free));
        System.out.printf("Percentage: %.2f%%%n", (1 - ((double) free / (double) total)) * 100);
        System.out.printf("Current income: $%d%n", billing.currentIncome());
        System.out.printf("Total income: $%d%n", billing.totalIncome());
    }
}
