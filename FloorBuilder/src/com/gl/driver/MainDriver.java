package com.gl.driver;

import java.util.Scanner;
import com.gl.floor_service.FloorService;

public class MainDriver {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int noOfFloors = 0;
		do {

			System.out.print("Enter the total no of floors in the building: ");
			noOfFloors = scanner.nextInt();

			if (noOfFloors > 0) {

				int[] floors = new int[noOfFloors];
				getFloorDetails(floors, noOfFloors);

				FloorService floorService = new FloorService();
				floorService.buildFloors(floors, noOfFloors);

			} else {
				System.out.println("Invalid number of floors");
			}

			System.out.println("\n\nDo you want to continue? Enter 0 to stop: ");
			noOfFloors = scanner.nextInt();
			System.out.println();

		} while (noOfFloors != 0);

		if (scanner != null)
			scanner.close();
	}

	private static void getFloorDetails(int[] floors, int noOfFloors) {
		for (int i = 0; i < noOfFloors; i++) {
			System.out.print("Enter the floor size given on day " + (i + 1) + ": ");
			floors[i] = scanner.nextInt();
		}

	}
}
