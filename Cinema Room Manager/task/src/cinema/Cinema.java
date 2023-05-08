package cinema;

public class Cinema {

    final private static int ROWS = 7;
    final private static int SEATS = 8;
    public static void main(String[] args) {
        // Write your code here
        CinemaArea area = new CinemaArea(ROWS, SEATS);

        area.print();
    }
}