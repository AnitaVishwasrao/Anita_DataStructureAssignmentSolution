package com.gl.floor_service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FloorService {

	public void buildFloors(int[] aFloors, int noOfFloors) {
		LinkedList<Floor> floors = new LinkedList<Floor>();
		LinkedList<Floor> delayedFloors = new LinkedList<Floor>();

		fillFloorList(floors, aFloors, noOfFloors);
		sortFloors(floors);

		System.out.println("\n-------------------------------------------\nThe order of construction is as follows");

		for (int i = 0; i < noOfFloors; i++) {
			System.out.print("Day " + (i + 1) + ": ");
			markFloorVisited(floors, aFloors[i]);
			markFloorVisited(delayedFloors, aFloors[i]);

			if (floors.size() > 0) {
				if (!isFloorSizeEqual(floors.get(0).size, aFloors[i])) {
					delayedFloors.add(floors.remove(0));
				} else {
					Floor floor = floors.remove(0);
					if (delayedFloors.size() > 0 && isFloorSizeEqual(delayedFloors.get(0).size, floor.size)) {
						buildTopFloors(delayedFloors, aFloors[i]); // build delayed floors which have size greater than
																	// current largest floor
						System.out.print(floor.size + " ");
					} else {
						delayedFloors.add(floor);
					}
				}
			}

			if (delayedFloors.size() > 0 && isFloorSizeEqual(delayedFloors.get(0).size, aFloors[i])) {
				buildTopFloors(delayedFloors, 0);
			}

			System.out.println();
		}

	}

	private void fillFloorList(LinkedList<Floor> floors, int[] aFloors, int noOfFloors) {
		for (int i = 0; i < noOfFloors; i++) {
			Floor floor = new Floor(aFloors[i], false);
			floors.add(floor);
		}
	}

	private void sortFloors(LinkedList<Floor> floors) {
		Collections.sort(floors, new Comparator<Floor>() {
			@Override
			public int compare(Floor floor1, Floor floor2) {
				return floor2.size - floor1.size;
			}
		});
	}

	private boolean isFloorSizeEqual(int fs1, int fs2) {
		return fs1 == fs2;
	}

	private void markFloorVisited(LinkedList<Floor> floors, int todaysFloorSize) {
		for (Floor floor : floors) {
			if (floor.size == todaysFloorSize) {
				floor.isVisited = true;
			}
		}
	}

	private void buildTopFloors(LinkedList<Floor> floors, int todaysFloorSize) {

		while (floors.size() > 0) {
			Floor floor = floors.get(0);
			if (!floor.isVisited)
				return;
			if (floor.size >= todaysFloorSize) {
				System.out.print(floor.size + " ");
				floors.remove(0);

			}
		}
	}
}