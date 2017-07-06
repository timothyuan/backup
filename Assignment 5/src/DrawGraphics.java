
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DrawGraphics {
    ArrayList<BouncingBox> boxes=new ArrayList<BouncingBox>();
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes.add(new BouncingBox(200, 50, Color.RED));
        boxes.add(new BouncingBox(100, 100, Color.RED));
        boxes.add(new BouncingBox(50, 150, Color.RED));
        for(int i=0; i<3; i++){
        	boxes.get(i).setMovementVector(i+1, i-1);
        }
    }

    /** Draw the contents of the window on surface. Called 20 times per second. 
     * @throws IOException */
    public void draw(Graphics surface) throws IOException {
        surface.drawLine(50, 50, 250, 250);
        for(BouncingBox b: boxes){
        	b.draw(surface);
        }
        surface.drawOval(50,50,50,50);
        surface.setColor(Color.BLUE);
        surface.fillOval(50, 50, 50, 50);
        //BufferedImage img=ImageIO.read(new File("img.jpg"));
        //surface.drawImage(img,100,100,null);
    }
} 