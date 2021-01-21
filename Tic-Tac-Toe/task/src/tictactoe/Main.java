package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();

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

        printBoard(cellsArr);

        int num1;
        int num2;
        while (true) {
            System.out.print("Enter the coordinates: ");

            String temp = scanner.nextLine();
            String[] numbers = temp.split(" ");
            if (!numbers[0].matches("\\d+") || !numbers[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
            }

            if (num1 < 1 || num1 > 3 || num2 < 0 || num2 > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else {
                num1--;
                num2--;
            }

            if (cellsArr[num1][num2] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                cellsArr[num1][num2] = 'X';
                printBoard(cellsArr);
                break;
            }
        }

        // Check game status
//        for (int i = 0; i < 3; i++) {
//            if (cellsArr[i][0] == cellsArr[i][1] && cellsArr[i][0] == cellsArr[i][2]) {
//                if (cellsArr[i][0] == 'X') {
//                    rowX++;
//                } else if (cellsArr[i][0] == 'O') {
//                    rowO++;
//                }
//            }
//            if (cellsArr[0][i] == cellsArr[1][i] && cellsArr[0][i] == cellsArr[2][i]) {
//                if (cellsArr[0][i] == 'X') {
//                    rowX++;
//                } else if (cellsArr[0][i] == 'O') {
//                    rowO++;
//                }
//            }
//        }
//        if ((cellsArr[0][0] == cellsArr[1][1] && cellsArr[0][0] == cellsArr[2][2]) ||
//                (cellsArr[0][2] == cellsArr[1][1] && cellsArr[0][2] == cellsArr[2][0])) {
//            if (cellsArr[1][1] == 'X') {
//                rowX++;
//            } else if (cellsArr[1][1] == 'O') {
//                rowO++;
//            }
//        }

        // Output result
//        if (x - o > 1 || o - x > 1 || (rowX > 0 && rowO > 0)) {
//            System.out.println("Impossible");
//        } else if (rowX > 0) {
//            System.out.println("X wins");
//        } else if (rowO > 0) {
//            System.out.println("O wins");
//        } else if (space) {
//            System.out.println("Game not finished");
//        } else {
//            System.out.println("Draw");
//        }
    }

    private static void printBoard(char[][] cells) {
        System.out.print("---------");
        System.out.printf("\n| %c %c %c |", cells[0][0], cells[0][1], cells[0][2]);
        System.out.printf("\n| %c %c %c |", cells[1][0], cells[1][1], cells[1][2]);
        System.out.printf("\n| %c %c %c |", cells[2][0], cells[2][1], cells[2][2]);
        System.out.print("\n---------\n");
    }
}
