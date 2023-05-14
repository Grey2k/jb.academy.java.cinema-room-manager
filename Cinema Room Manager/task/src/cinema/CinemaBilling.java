package cinema;

public class CinemaBilling {

    final private static int SMALL_CINEMA = 60;
    final private static int FRONT_SEAT_PRICE = 10;
    final private static int BACK_SEAT_PRICE = 8;

    final private CinemaHall cinema;

    private int currentIncome = 0;

    public CinemaBilling(CinemaHall area) {
        cinema = area;
    }

    public int totalIncome() {
        int total = 0;

        if (cinema.total() <= SMALL_CINEMA) {
            total = cinema.total() * FRONT_SEAT_PRICE;
        } else {
            int frontRows = cinema.rowsTotal / 2;
            int backRows = cinema.rowsTotal - frontRows;

            total = frontRows * cinema.seatsTotal * FRONT_SEAT_PRICE +
                    backRows * cinema.seatsTotal * BACK_SEAT_PRICE;
        }

        return total;
    }

    public int currentIncome() {
        return currentIncome;
    }

    public CinemaSeat buy(int rowNum, int seatNum) {
        CinemaSeat seat;

        try {
            seat = cinema.seats[rowNum - 1][seatNum - 1];
        } catch (IndexOutOfBoundsException any) {
            throw new RuntimeException("Wrong input!");
        }

        if (seat.sold) {
            throw new RuntimeException("That ticket has already been purchased!");
        }

        seat.sold = true;
        currentIncome += getPrice(seat);

        return seat;
    }

    public int getPrice(CinemaSeat seat) {
        if (cinema.total() <= SMALL_CINEMA) {
            return FRONT_SEAT_PRICE;
        }

        return seat.row <= cinema.rowsTotal / 2 ? FRONT_SEAT_PRICE : BACK_SEAT_PRICE;
    }
}
