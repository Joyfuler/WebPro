package practice;

public interface ILendable {
    public int STATE_BORROWED = 1;
    public int STATE_NORMAL = 0;

    public void checkOut(String bookNo, String name);

    public void checkIn();
    public void printState();
}
