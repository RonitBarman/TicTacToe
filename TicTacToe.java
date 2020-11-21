import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        String[][] board = new String[3][3];
        emptyBoard(board);
        printBoard(board);
        while (true) {
            
            while (true) {
                System.out.println("Position X:");
                str = scanner.next();
                if (move(board, str, "X") == true) break;
            }
            printBoard(board);
            if (checkRows(board, "X")) {
                System.out.println("X Has Won!");
                break;
            } else if (checkDiag(board, "X")) {
                System.out.println("X Has Won!");
                break;
            } else if (checkColumns(board, "X")) {
                System.out.println("X Has Won!");
                break;
            } else if (isTie(board)) {
                System.out.println("Tie!");
                break;
            }
            while (true) {
                System.out.println("Position O:");
                str = scanner.next();
                if (move(board, str, "O") == true) break;
            }
            printBoard(board);
            if (checkRows(board, "O")) {
                System.out.println("O Has Won!");
                break;
            } else if (checkDiag(board, "O")) {
                System.out.println("O Has Won!");
                break;
            } else if (checkColumns(board, "X")) {
                System.out.println("O Has Won!");
                break;
            } else if (isTie(board)) {
                System.out.println("Tie!");
                break;
            }
        }
        System.out.println("Play again? (y/n)");
        if (scanner.next().equals("y")) startGame();
        scanner.close();
    }

    static boolean move(String[][] board, String pos, String type) {
        int x = 0; 
        int y = 0;
        try {
            x = (int) pos.split("")[0].charAt(0) - 65;
            y = Integer.parseInt(pos.split("")[1]) - 1;
        } catch (Exception e) {
            System.out.println("Invalid position!");
            throw e;
        }
        if (!board[x][y].equals(" ")) {
            System.out.println("Must choose empty space!");
            return false;
        } else board[x][y] = type;
        return true;
    }
    static void emptyBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) board[i][j] = " ";
        }
    }
    static void printBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.print(" "+board[i][0]+" ");
            System.out.print("|");
            System.out.print(" "+board[i][1]+" ");
            System.out.print("|");
            System.out.println(" "+board[i][2]+" ");
            if (i != 2) System.out.println("---|---|---");

        }
    }

    static boolean isTie(String[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) break;
                count++;
            }
        }
        if (count != 9) return false;
        else return true;
    }
    static boolean checkDiag(String[][] board, String c) {
        if (board[0][0].equals(c) && board[1][1].equals(c) && board[2][2].equals(c)) return true;
        else if (board[0][2].equals(c) && board[1][1].equals(c) && board[2][0].equals(c)) return true;
        return false;
    }
    static boolean checkRows(String[][] board, String c) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(c)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else count = 0;
        }
        return false;
    }
    static boolean checkColumns(String[][] board, String c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals(c)) count++;
            }
            if (count == 3) return true;
            else count = 0;
        }
        return false;
    }
}
