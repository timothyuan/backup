import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	PImage img;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	public void settings(){
		size(640,360);
		
	}
	public void setup(){
		img=loadImage("img.jpg");
		img.resize(640,360);
		
	}
	public void draw(){
		int x = (int)random(img.width);
		int y = (int)random(img.height);
		int loc = x+y*img.width;
		float r = red(img.pixels[loc]);	
		float g = green(img.pixels[loc]);
		float b = blue(img.pixels[loc]);
		noStroke();
		fill(r,g,b,100);
		ellipse(x,y,10,10);
			
		
	}
}
