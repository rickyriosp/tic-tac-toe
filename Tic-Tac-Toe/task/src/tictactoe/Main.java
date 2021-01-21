package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 0;
        int o = 0;
        int rowX = 0;
        int rowO = 0;
        boolean space = false;
        boolean playerX = true;
        char[][] cells  = new char[][] {{'_','_','_'},{'_','_','_'}, {'_','_','_'}};

        printBoard(cells);

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

            if (cells[num1][num2] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                if (playerX) {
                    cells[num1][num2] = 'X';
                    playerX = false;
                    x++;
                } else {
                    cells[num1][num2] = 'O';
                    playerX = true;
                    o++;
                }
                printBoard(cells);

                // Check game status
                space = false;
                for (int i = 0; i < 3; i++) {
                    if (cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2]) {
                        if (cells[i][0] == 'X') {
                            rowX++;
                        } else if (cells[i][0] == 'O') {
                            rowO++;
                        }
                    }
                    if (cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i]) {
                        if (cells[0][i] == 'X') {
                            rowX++;
                        } else if (cells[0][i] == 'O') {
                            rowO++;
                        }
                    }

                    for (int j = 0; j < 3; j++) {
                        if (cells[i][j] == '_') {
                            space = true;
                            break;
                        }
                    }
                }
                if ((cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]) ||
                        (cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0])) {
                    if (cells[1][1] == 'X') {
                        rowX++;
                    } else if (cells[1][1] == 'O') {
                        rowO++;
                    }
                }
            }

            // Output result
            if (x - o > 1 || o - x > 1 || (rowX > 0 && rowO > 0)) {
                System.out.println("Impossible");
                break;
            } else if (rowX > 0) {
                System.out.println("X wins");
                break;
            } else if (rowO > 0) {
                System.out.println("O wins");
                break;
            } else if (!space){
                System.out.println("Draw");
                break;
            } else {
                continue;
                // System.out.println("Game not finished");
            }
        }
    }

    private static void printBoard(char[][] cells) {
        System.out.print("---------");
        System.out.printf("\n| %c %c %c |", cells[0][0], cells[0][1], cells[0][2]);
        System.out.printf("\n| %c %c %c |", cells[1][0], cells[1][1], cells[1][2]);
        System.out.printf("\n| %c %c %c |", cells[2][0], cells[2][1], cells[2][2]);
        System.out.print("\n---------\n");
    }
}
