package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();

        System.out.print("---------");
        System.out.printf("\n| %c %c %c |", cells.charAt(0), cells.charAt(1), cells.charAt(2));
        System.out.printf("\n| %c %c %c |", cells.charAt(3), cells.charAt(4), cells.charAt(5));
        System.out.printf("\n| %c %c %c |", cells.charAt(6), cells.charAt(7), cells.charAt(8));
        System.out.print("\n---------\n");

        int x = 0;
        int o = 0;
        int rowX = 0;
        int rowO = 0;
        boolean space = false;
        char[][] cellsArr  = new char[3][3];

        for (int i = 0; i < 9; i++) {
            char cell = cells.charAt(i);
            cellsArr[i / 3][i - (i / 3) * 3] = cell;
            if (cell == 'X') {
                x++;
            } else if (cell == 'O') {
                o++;
            } else {
                space = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cellsArr[i][0] == cellsArr[i][1] && cellsArr[i][0] == cellsArr[i][2]) {
                if (cellsArr[i][0] == 'X') {
                    rowX++;
                } else if (cellsArr[i][0] == 'O') {
                    rowO++;
                }
            }
            if (cellsArr[0][i] == cellsArr[1][i] && cellsArr[0][i] == cellsArr[2][i]) {
                if (cellsArr[0][i] == 'X') {
                    rowX++;
                } else if (cellsArr[0][i] == 'O') {
                    rowO++;
                }
            }
        }

        if ((cellsArr[0][0] == cellsArr[1][1] && cellsArr[0][0] == cellsArr[2][2]) ||
                (cellsArr[0][2] == cellsArr[1][1] && cellsArr[0][2] == cellsArr[2][0])) {
            if (cellsArr[1][1] == 'X') {
                rowX++;
            } else if (cellsArr[1][1] == 'O') {
                rowO++;
            }
        }


        if (x - o > 1 || o - x > 1 || (rowX > 0 && rowO > 0)) {
            System.out.println("Impossible");
        } else if (rowX > 0) {
            System.out.println("X wins");
        } else if (rowO > 0) {
            System.out.println("O wins");
        } else if (space) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }
}
