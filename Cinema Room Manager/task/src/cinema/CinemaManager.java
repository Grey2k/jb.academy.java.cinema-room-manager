package cinema;

import java.util.Scanner;

final public class CinemaManager {

    final private CinemaArea cinema;
    final private CinemaBilling billing;

    public CinemaManager(CinemaArea area) {
        cinema = area;
        billing = new CinemaBilling(cinema);
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
                case 0 -> exited = true;
                default -> System.out.println("Unknown command");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    private void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        CinemaSeat seat = new CinemaSeat(rowNum, seatNum);
        billing.book(seat);

        System.out.printf("%nTicket price: $%d%n", billing.getPrice(seat));
    }
}
