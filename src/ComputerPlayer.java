public class ComputerPlayer implements Player{
    private final char symbol;

    ComputerPlayer(char symbol){
        this.symbol = symbol;
    }

    @Override
    public int[] makeMove() {
        int row = (int)(Math.random() * 2);
        int col = (int)(Math.random() * 3);
        return new int[]{row, col};
    }
    public char getSymbol() {
        return symbol;
    }
}
