import processing.core.PApplet;
import processing.core.PImage;

public class Bird {
	PApplet processing;
	public float x,y,velocityY,width,height;
	PImage img;
	
	Bird(PApplet processing){
		this.processing=processing;
		this.x=processing.width/2;
		this.y=processing.height/2;
		this.velocityY=0;
		this.img=processing.loadImage("bird.png");
		this.width=25;
		this.height=25;
	}
	
	
	public void move(){
		y+=velocityY;
		velocityY += 0.2f;
		if(y+height>processing.height){
			y=processing.height-height;
			velocityY=0;
		}else if (y<0){
			y=0;
			velocityY=0;
		}
	}
	
	public void flap(){
		velocityY-=5;
		if(velocityY<-6){
			velocityY=-6;
		}else if (velocityY>4){
			velocityY=4;
		}
	}
	
	public void draw(){
		processing.image(img, x, y, width, height);
	}
}
