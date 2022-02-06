package com.gl.floor_service;

public class Floor {
	public int size;
	public boolean isVisited;

	public Floor() {
		size = 0;
		isVisited = false;
	}

	public Floor(int floor, boolean isVisited) {
		this.size = floor;
		this.isVisited = isVisited;
	}
}
