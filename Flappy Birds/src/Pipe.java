import processing.core.PApplet;
import processing.core.PImage;
public class Pipe {
	PApplet processing;
	float x,width;
	float centerPoint,difference;
	PImage img;

	
	Pipe(PApplet processing){
		this.processing=processing;
		this.x=processing.width+width/2;
		this.width=75;
		this.centerPoint=processing.random(-100,100)+processing.height/2;
		this.difference=processing.random(30,60);
		this.img=processing.loadImage("img.png");
		
		
	}
	public void move(){
		x--;
		
	}
	public void draw(){
		processing.pushMatrix();
		processing.translate(x+width, 0);
		processing.rotate(processing.PI);
		processing.image(img,0,0,width,-1*(centerPoint-difference));
		processing.popMatrix();
		processing.image(img, x, centerPoint+difference,width,processing.height-centerPoint+difference);
		
	}
	public boolean collided(Bird player){
		if(player.x + player.width/4>x-width/2){
			if(player.x-player.width/4<x+width/2){
				if(player.y+player.height/4>centerPoint+difference||player.y-player.height/4<centerPoint-difference){
					return true;
				}
			}
		}return false;
	}
	

}
