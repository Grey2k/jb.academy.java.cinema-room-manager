package cinema;

final public class CinemaArea {

    final public String[][] plan;
    final public int rows;
    final public int seats;

    public CinemaArea(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.plan = new String[this.rows][this.seats];
    }

    public void print() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();

        // Printing seats
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.printf(" %s", plan[i][j] == null ? "S" : plan[i][j]);
            }
            System.out.println();
        }
    }

    public int total() {
        return rows * seats;
    }
}
