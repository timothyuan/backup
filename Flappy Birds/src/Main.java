import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {
	ArrayList<Pipe> pipes;
	Bird player;
	public int GAMESTATE = 0;
	public static final int GAME_MENU = 0;
	public static final int GAME_PLAY = 1;
	public static final int GAME_OVER = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");

	}

	public void settings() {
		size(640, 360);

	}

	public void setup() {
		pipes = new ArrayList<Pipe>();
		player = new Bird(this);
	}

	public void draw() {
		if (GAMESTATE == GAME_MENU) {
			textAlign(CENTER,CENTER);
			text("SPACE TO START", width/2, height/2);
		} else if (GAMESTATE == GAME_PLAY) {
			background(135, 206, 250);
			if (frameCount % 180 == 0) {
				pipes.add(new Pipe(this));
			}
			drawAllPipes();
			moveAllPipes();
			checkforCollisions();
			player.move();
			player.draw();
		} else if (GAMESTATE == GAME_OVER) {
			textAlign(CENTER,CENTER);
			text("GAME OVER", width/2, height/2);
		}
	}

	public void mousePressed() {
		player.flap();
	}

	public void keyPressed() {
		if (GAMESTATE == GAME_MENU) {
			if (key == ' ') {
				GAMESTATE = GAME_PLAY;
				setup();
			}
		} else if (GAMESTATE == GAME_OVER) {
			if (key == ' ') {
				GAMESTATE = GAME_PLAY;
				setup();
			}
		}
	}

	public void drawAllPipes() {
		for (Pipe p : pipes) {
			p.draw();
		}
	}

	public void moveAllPipes() {
		for (Pipe p : pipes) {
			p.move();
		}
	}

	public void checkforCollisions() {
		for (Pipe p : pipes) {
			if (p.collided(player)) {
				print("you lost");
				GAMESTATE = GAME_OVER;
			}
		}
	}

}
