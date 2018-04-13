package com.bilal.moves;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Spot source = new Spot(), destination = new Spot();
		System.out.println("Source information");
		System.out.println("==================");
		System.out.print("X: ");
		source.setX(scanner.nextInt());
		System.out.print("Y: ");
		source.setY(scanner.nextInt());
		System.out.print("\n");
		System.out.println("Destination information");
		System.out.println("=======================");
		System.out.print("X: ");
		destination.setX(scanner.nextInt());
		System.out.print("Y: ");
		destination.setY(scanner.nextInt());
		System.out.print("\n");
		scanner.close();
		
		int count = elephantMovesCounter(source, destination);
		if (count <= 0)
			System.out.println("Move is not allowed");
		else
			System.out.println("It can be done by: " + count);

	}

	public static int elephantMovesCounter(Spot from, Spot to) {
		// Notes: 1- Any legal (respect to elephant position) move for elephant
		// can be made by 1 move or 2 as maximum
		// 2- if the difference between x and y among source and destination is
		// equal, it can be done by 1 move
		// 3- if the mod by 2 of the summation of differences between x and y
		// among source and destination equal zero, it can be done by 2 moves
		// 4- otherwise the move is illegal
		if (to.getX() < 0 || from.getX() < 0 || to.getY() < 0 || from.getY() < 0)
			throw new NumberFormatException("Negative spots are not available");
		if ((to.getX() - from.getX()) == (to.getY() - from.getY()))
			return 1;
		else if (((to.getX() - from.getX()) + (to.getY() - from.getY())) % 2 == 0)
			return 2;
		else
			return 0;
	}
}
