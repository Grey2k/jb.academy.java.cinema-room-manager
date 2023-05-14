package cinema;

final public class CinemaSeat {

    final public int row;
    final public int seat;

    public boolean sold = false;

    public CinemaSeat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }
}
