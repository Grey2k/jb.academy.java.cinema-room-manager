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

        CinemaArea area = new CinemaArea(rows, seats);
        CinemaBilling billing = new CinemaBilling(area);

        area.print();

        // book a seat
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        CinemaSeat seat = new CinemaSeat(rowNum, seatNum);
        billing.book(seat);

        // print result
        System.out.printf("%nTicket price: $%d%n", billing.getPrice(seat));
        area.print();
    }
}