package cinema;

public class CinemaBilling {

    final private static int SMALL_CINEMA = 60;
    final private static int FRONT_SEAT_PRICE = 10;
    final private static int BACK_SEAT_PRICE = 8;

    final private CinemaArea cinema;
    public CinemaBilling(CinemaArea area) {
        cinema = area;
    }

    public int totalIncome() {
        int total = 0;

        if(cinema.total() <= SMALL_CINEMA) {
            total = cinema.total() * FRONT_SEAT_PRICE;
        }
        else {
            int frontRows = cinema.rows / 2;
            int backRows = cinema.rows - frontRows;

            total = frontRows * cinema.seats * FRONT_SEAT_PRICE +
                    backRows * cinema.seats * BACK_SEAT_PRICE;
        }

        return total;
    }
}
