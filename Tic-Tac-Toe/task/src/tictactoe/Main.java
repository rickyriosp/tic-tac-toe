package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();

        System.out.print("\n---------");
        System.out.printf("\n| %c %c %c |", cells.charAt(0), cells.charAt(1), cells.charAt(2));
        System.out.printf("\n| %c %c %c |", cells.charAt(3), cells.charAt(4), cells.charAt(5));
        System.out.printf("\n| %c %c %c |", cells.charAt(6), cells.charAt(7), cells.charAt(8));
        System.out.print("\n---------");
    }
}
