package cinema;

final public class CinemaHall {

    public CinemaSeat[][] seats;
    final public int rowsTotal;
    final public int seatsTotal;

    public CinemaHall(int rows, int seats) {
        this.rowsTotal = rows;
        this.seatsTotal = seats;

        initializePlan();
    }

    public void initializePlan() {
        seats = new CinemaSeat[rowsTotal][seatsTotal];

        for (int i = 0; i < rowsTotal; i++) {
            for (int j = 0; j < seatsTotal; j++) {
                seats[i][j] = new CinemaSeat(i + 1, j + 1);
            }
        }
    }

    public void print() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seatsTotal; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();

        // Printing seats
        for (int i = 0; i < rowsTotal; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatsTotal; j++) {
                System.out.printf(" %s", seats[i][j].sold ? "B" : "S");
            }
            System.out.println();
        }
    }

    public int total() {
        return rowsTotal * seatsTotal;
    }

    public int free() {
        int free = 0;

        for (CinemaSeat[] row : seats) {
            for (CinemaSeat seat : row) {
                if (!seat.sold) {
                    free++;
                }
            }
        }

        return free;
    }
}
