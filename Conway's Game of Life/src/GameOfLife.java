import processing.core.PApplet;

public class GameOfLife extends PApplet {
	int[][] cells;
	int[][] cellBuffer;
	int cellSize = 5;
	float probabilityOfAliveAtStart = 15;
	int alive = color(0, 200, 0);
	int dead = color(0);
	int interval = 6;
	boolean pause = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("GameOfLife");
	}

	public void settings() {
		size(320, 180);
	}

	public void setup() {
		cells = new int[width / cellSize][height / cellSize];
		cellBuffer = new int[width / cellSize][height / cellSize];
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				float state = random(100);
				if (state > probabilityOfAliveAtStart) {
					state = 0;
				} else {
					state = 1;
				}
				cells[x][y] = (int) state;
			}
		}
		background(0);
		stroke(48);

	}

	public void draw() {
		drawCells();
		if (frameCount % interval == 0 && !pause) {
			copyCells();
			iteration();
		}

	}

	public void copyCells() {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				cellBuffer[x][y] = cells[x][y];
			}
		}

	}

	public void iteration() {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				int neighbors = 0;
				for (int localX = x - 1; localX <= x + 1; localX++) {
					for (int localY = y - 1; localY <= y + 1; localY++) {
						if (localX >= 0 && localX < cells.length) {
							if (localY >= 0 && localY < cells[0].length) {
								if (!((localX == x) && (localY == y))) {
									if (cells[localX][localY] == 1) {
										neighbors++;
									}
								}
							}
						}
					}
				}
				if (cellBuffer[x][y] == 1) {
					if (neighbors < 2 || neighbors > 3) {
						cells[x][y] = 0;
					}
				} else {
					if (neighbors == 3) {
						cells[x][y] = 1;
					}
				}
			}
		}
	}

	public void drawCells() {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				if (cells[x][y] == 1) {
					fill(alive);
				} else {
					fill(dead);
				}
				rect(x * cellSize, y * cellSize, cellSize, cellSize);
			}
		}
	}

	public void mousePressed() {
		int xCellOver = (int) map(mouseX, 0, width, 0, width / cellSize);
		xCellOver = constrain(xCellOver, 0, width / cellSize - 1);
		int yCellOver = (int) map(mouseY, 0, height, 0, height / cellSize);
		yCellOver = constrain(yCellOver, 0, height / cellSize - 1);
		if (cells[xCellOver][yCellOver] == 1) {
			cells[xCellOver][yCellOver] = 0;
		} else
			cells[xCellOver][yCellOver] = 1;

	}

	public void keyPressed() {
		if (key == ' ') {
			pause = !pause;

		} else if (key == 'r') {
			setup();
		} else if (key == 'c') {
			for (int x = 0; x < cells.length; x++) {
				for (int y = 0; y < cells[0].length; y++) {
					cells[x][y] = 0;
				}
			}
		}
	}
}
