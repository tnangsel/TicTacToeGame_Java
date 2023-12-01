import java.util.Scanner;

public class HumanPlayer implements Player{
    private final char symbol;
    private final Scanner scanner;

    HumanPlayer(char symbol){
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] makeMove() {
        System.out.println("Enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.println("Enter column (0-2): ");
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    public char getSymbol() {
        return symbol;
    }
}