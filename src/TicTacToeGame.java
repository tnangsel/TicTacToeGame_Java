public class TicTacToeGame {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private final char[][] board;
    private final Player[] players;
    private int currentPlayerIndex;

    public TicTacToeGame(Player player1, Player player2) {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
        players = new Player[]{player1, player2};
        this.currentPlayerIndex = 0;   //initial current position set to 0
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE; j++){
                board[i][j] = ' ';
            }
        }
    }

    private void displayBoard() {
        System.out.println("--------------------------");
        for (int i = 0; i < BOARD_SIZE; i ++){
            for (int j = 0; j < BOARD_SIZE; j++){
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("------------------------");
        }
    }

    public void play() {
        while (true) {
            displayBoard();
            int[] move = players[currentPlayerIndex].makeMove();

            if (isValidMove(move)) {
                makeMove(move);
                if (isWinner()) {
                    displayBoard();
                    System.out.println("Player " + players[currentPlayerIndex].getSymbol() + " wins!");
                    break;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                switchPlayer();
            }
        }
    }
    private boolean isValidMove(int[] move) {
        int row = move[0];
        int col = move[1];

        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        return true;
    }

    private void makeMove(int[] move) {
        int row = move[0];
        int col = move[1];
        board[row][col] = players[currentPlayerIndex].getSymbol();
    }

    private boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] != EMPTY_CELL && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i] != EMPTY_CELL && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] != EMPTY_CELL && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != EMPTY_CELL && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    public static void main(String[] args) {
        Player player1 = new HumanPlayer('X');
        Player player2 = new ComputerPlayer('O');

        TicTacToeGame game = new TicTacToeGame(player1, player2);
        game.play();
    }
}
